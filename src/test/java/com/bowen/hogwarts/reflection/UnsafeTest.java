package com.bowen.hogwarts.reflection;

import java.lang.reflect.Field;
import org.junit.jupiter.api.Test;
import sun.misc.Unsafe;

/**
 * @author zhaobaowen
 */
public class UnsafeTest {

  @Test
  public void test() throws NoSuchFieldException, IllegalAccessException {
    Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
    theUnsafe.setAccessible(true);
    Unsafe unsafe = (Unsafe) theUnsafe.get(null);

  }

  @Test
  public void test2() {
    System.out.println(new Object());
    System.out.println(new Object());
  }

}
