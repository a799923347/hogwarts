package com.bowen.hogwarts.binarynumber;

import java.util.concurrent.atomic.AtomicInteger;
import org.junit.Test;

/**
 * @author zhaobaowen
 */
public class BinaryNumberTest {

  private static int COUNT_BITS = Integer.SIZE - 3;

  private static int CAPACITY = (1 << COUNT_BITS) - 1;

  @Test
  public void test() {
    int RUNNING = -1 << COUNT_BITS;
    AtomicInteger ctl = new AtomicInteger(ctlOf(RUNNING, 0));
    System.out.println(workerCountOf(ctl.get()));
  }

  private static int ctlOf(int rs, int wc) {
    return rs | wc;
  }

  private static int workerCountOf(int c) {
    return c & CAPACITY;
  }

}
