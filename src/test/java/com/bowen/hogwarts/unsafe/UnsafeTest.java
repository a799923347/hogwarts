package com.bowen.hogwarts.unsafe;

import java.lang.reflect.Field;
import org.junit.jupiter.api.Test;
import sun.misc.Unsafe;
import sun.reflect.Reflection;

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

}
