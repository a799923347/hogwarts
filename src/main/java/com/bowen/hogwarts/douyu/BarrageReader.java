package com.bowen.hogwarts.douyu;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zhaobaowen
 */
@Slf4j
public class BarrageReader {

  private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

  public static void main(String[] args) throws IOException, InterruptedException {
    Socket socket = new Socket("openbarrage.douyutv.com", 8601);

    //发送登录请求(登入9999房间)
    String loginCMD = "type@=loginreq/roomid@=229346/";
    send(loginCMD, socket);

    //读取登录请求消息
    byte[] bytes = read(socket);
    String msg = new String(Arrays.copyOfRange(bytes, 0, bytes.length));
    System.out.println(msg);

    //加入弹幕分组开始接收弹幕
    String joinGroupCMD = "type@=joingroup/rid@=229346/gid@=-9999/";
    send(joinGroupCMD, socket);
    scheduler.scheduleAtFixedRate(() -> {
      log.info("heartbeat......");
      String heartBeat = "type@=mrkl/";
      send(heartBeat, socket);
    }, 1, 1, TimeUnit.MINUTES);

    //循环读取弹幕消息开始
    while (true) {
      byte[] msgBytes = read(socket);
      if (msgBytes == null) {
        continue;
      }
      String s = new String(Arrays.copyOfRange(msgBytes, 0, msgBytes.length));
      BarrageDo barrageDo;
      try {
        barrageDo = DeserializerUtil.deserialize(s.replace("\u0000", ""));
      } catch (Exception e) {
        log.error("反序列化异常，string={}", s, e);
        continue;
      }
      if (barrageDo.getType() != null && barrageDo.getType().equalsIgnoreCase("chatmsg")) {
        log.info("{}:{},等级={},粉丝牌={}", barrageDo.getNn(), barrageDo.getTxt(), barrageDo.getLevel(),
            barrageDo.getBnn());
        // System.out.println(String.format("<%s>:%s           等级=%s,粉丝牌=%s", barrageDo.getNn(), barrageDo.getTxt(), barrageDo.getLevel(), barrageDo.getBnn()));
        //System.out.println(JSON.toJSONString(barrageDo));
      }
      // if (s.contains("txt@=")) {
      //   System.out.println(s);
      // }
      // Thread.sleep(1);
    }
    //关闭链接
    //socket.close();
  }

  /**
   * 发送消息
   *
   * @param content
   */
  private static void send(String content, Socket socket) {
    try {
      // 消息长度，表示整条消息的长度（包括自身）？
      // 该长度为一次性write的数据流长度，即消息长度4个字节*2+消息类型2个字节+加密字段1个字节+保留字段1个字节+数据内容长度+结尾标志1个字节
      // 但为什么少加了一个4？8为头部的长度？
      // 计算消息长度 = 消息长度(4) + 消息类型(4) + 真实消息内容长度 + 结尾标识长度(1)
      int contenLeng = 4 + 4 + content.length() + 1;
      //小端模式转换init (长度1)
      byte[] contenLeng1 = intToBytesLittle(contenLeng);
      //小端模式转换init (长度2)
      byte[] contenLeng2 = intToBytesLittle(contenLeng);
      //小端模式转换init (消息类型) (689:客户端发送给弹幕服务器的文本格式数据)
      byte[] msgType = intToBytesLittle(689);
      //标识数据结尾
      int end = 0;

      ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
      // 写入长度1 协议头中第一个消息长度
      byteArray.write(contenLeng1);
      // 写入长度2（与长度1相同） 协议头中头部里面的消息长度
      byteArray.write(contenLeng2);
      // 写入消息类型 头部里的消息类型
      // 协议中要求消息类型为2字节"小端"整数，加密字段和保留字段均默认为0，
      // 所以此处直接将689转成四字节小端整数就得到了所需的"消息类型+加密字段+保留字段"的四字节数据
      byteArray.write(msgType);
      //写入消息内容
      byteArray.write(content.getBytes(StandardCharsets.UTF_8));
      //写入数据结尾标识
      byteArray.write(end);

      //发送数据
      OutputStream out = socket.getOutputStream();
      out.write(byteArray.toByteArray());
      out.flush();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * 读取消息
   *
   * @return
   */
  private static byte[] read(Socket socket) {
    try {
      InputStream inputStream = socket.getInputStream();
      //下条信息的长度
      int contentLen = 0;

      //读取前4个字节，得到数据长度
      byte[] bytes1 = readStream(inputStream, 0, 4);
      //用小端模式转换byte数组为
      contentLen = bytesToIntLittle(bytes1, 0);

      //继续读取4个字节，得到第二个 数据长度
      byte[] bytes2 = readStream(inputStream, 0, 4);
      int contentLen2 = bytesToIntLittle(bytes2, 0);

      //再次读取4个字节，得到消息类型
      byte[] bytes3 = readStream(inputStream, 0, 4);
      //将小端整数转换为大端整数
      int msgType = bytesToIntLittle(bytes3, 0);

      //
      contentLen = contentLen - 8;
      //继续读取真正的消息内容
      //本次读取数据长度
      int len = 0;
      //已读数据长度
      int readLen = 0;
      if (contentLen <= 0) {
        log.info("contentLen={}", contentLen);
        return new ByteArrayOutputStream().toByteArray();
      }
      if (contentLen > 1000) {
        log.info("contentLen={}", contentLen);
        // inputStream.skip(contentLen);
        // return new ByteArrayOutputStream().toByteArray();
      }
      byte[] bytes = new byte[contentLen];
      ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
      while ((len = inputStream.read(bytes, 0, contentLen - readLen)) != -1) {
        byteArray.write(bytes, 0, len);
        readLen += len;
        if (readLen == contentLen) {
          break;
        }
      }

      return byteArray.toByteArray();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * 计算消息体长度
   */
  private static int calcMessageLength(String content) {
    return 4 + 4 + (content == null ? 0 : content.length()) + 1;
  }


  /**
   * 以小端模式将int转成byte[]
   */
  private static byte[] intToBytesLittle(int value) {
    byte[] src = new byte[4];
    src[3] = (byte) ((value >> 24) & 0xFF);
    src[2] = (byte) ((value >> 16) & 0xFF);
    src[1] = (byte) ((value >> 8) & 0xFF);
    src[0] = (byte) (value & 0xFF);
    return src;
  }


  /**
   * 以小端模式将byte[]转成int
   */
  private static int bytesToIntLittle(byte[] src, int offset) {
    int value;
    value = (int) ((src[offset] & 0xFF)
        | ((src[offset + 1] & 0xFF) << 8)
        | ((src[offset + 2] & 0xFF) << 16)
        | ((src[offset + 3] & 0xFF) << 24));
    return value;
  }


  /**
   * 从流中读取数据
   */
  private static byte[] readStream(InputStream inputStream, int off, int len) throws IOException {
    byte[] bytes = new byte[len];
    inputStream.read(bytes, 0, 4);
    return bytes;
  }
}
