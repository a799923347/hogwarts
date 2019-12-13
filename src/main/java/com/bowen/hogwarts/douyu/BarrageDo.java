package com.bowen.hogwarts.douyu;

import lombok.Data;

/**
 * @author zhaobaowen
 */
@Data
public class BarrageDo {

  /**
   * 类型
   * chatmsg: 弹幕
   */
  private String type;

  /**
   * 房间id
   */
  private String rid;

  /**
   * 客户端类型
   */
  private String ct;

  /**
   * 发送者uid
   */
  private String uid;

  /**
   * 发送者昵称
   */
  private String nn;

  /**
   * 弹幕文本内容
   */
  private String txt;

  /**
   * 弹幕唯一id
   */
  private String cid;

  /**
   * 用户头像
   */
  private String ic;

  /**
   * 用户等级
   */
  private String level;

  /**
   * 扩展字段，一般不使用，可忽略
   */
  private String sahf;

  /**
   *
   */
  private String cst;

  /**
   * 徽章昵称
   */
  private String bnn;

  /**
   * 徽章等级
   */
  private String bl;

  /**
   * 徽章房间id
   */
  private String brid;

  /**
   * 徽章信息校验码
   */
  private String hc;

  /**
   *
   */
  private String cbid;

  /**
   * 用户获得的连击特效：数组类型，数组包括eid（特效id），etp（特效类型），sc（特效次数），ef（特效标志）
   */
  private String el;

  /**
   *
   */
  private String lk;

  /**
   *
   */
  private String fl;
}
