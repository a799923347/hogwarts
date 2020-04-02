package com.bowen.hogwarts.objectlayout;

import org.junit.Test;
import org.openjdk.jol.info.ClassLayout;

/**
 * @author zhaobaowen
 */
public class ObjectLayoutTest {

  @Test
  public void test() {
    Object myObject = new Object();
    System.out.println(ClassLayout.parseInstance(myObject).toPrintable());
    synchronized (myObject) {
      System.out.println(ClassLayout.parseInstance(myObject).toPrintable());
      System.out.println("hashcode: " + myObject.hashCode());
      System.out.println(ClassLayout.parseInstance(myObject).toPrintable());
    }
  }

}
