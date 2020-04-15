package com.bowen.hogwarts.fieldaccess;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import org.junit.Test;

/**
 * @author zhaobaowen
 */
public class FieldAccessTest {

  @Test
  public void test() {
    MyFieldAccessObject a1 = new MyFieldAccessObject();
    Field[] fields = a1.getClass().getDeclaredFields();
    AccessibleObject.setAccessible(fields, true);
    try {
      System.out.println(fields[0].toString() + "=" + fields[0].get(a1));
      fields[0].setInt(a1, 150);
      System.out.print(fields[0].toString() + "=" + fields[0].get(a1));
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

}
