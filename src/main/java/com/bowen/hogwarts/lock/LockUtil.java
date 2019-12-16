package com.bowen.hogwarts.lock;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author zhaobaowen
 */
@Slf4j
@Service
public class LockUtil {

  private static int myInt = 0;

  public static synchronized void test() throws InterruptedException {
    log.info("当前获取锁的线程为={}", Thread.currentThread());
    myInt++;
    log.info("计算器值={}", myInt);
    // 休眠一段时间，方式代码执行过快，保证有锁的竞争
    Thread.sleep(500);
  }

  public void test2() {
    synchronized (this) {
      myInt++;
      System.out.println(myInt);
    }
  }

}
