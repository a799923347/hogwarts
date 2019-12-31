package com.bowen.hogwarts.reflection;

import org.junit.Test;

/**
 * @author zhaobaowen
 */
public class ClassTypeAndReflectionTest {

  @Test
  public void test() {
    ClassTypeAndReflectionTest cla1 = new ClassTypeAndReflectionTest();
    Class<? extends ClassTypeAndReflectionTest> aClass1 = cla1.getClass();
    Class<ClassTypeAndReflectionTest> aClass2 = ClassTypeAndReflectionTest.class;
    Class<?> aClass3 = null;
    try {
      aClass3 = Class.forName("com.bowen.hogwarts.reflection.ClassTypeAndReflectionTest");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    System.out.println(aClass1 == aClass2);
    System.out.println(aClass1 == aClass3);
  }

}
