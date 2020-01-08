package com.bowen.hogwarts.generics;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.junit.Test;

/**
 * @author zhaobaowen
 */
public class GenericTest {

  @Test
  public void test()
      throws NoSuchFieldException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
    GenericTestHelperBean<String> helperBean = new GenericTestHelperBean<>();
    helperBean.setValue("hahaha");

    // 属性上的泛型类型
    Field value = helperBean.getClass().getDeclaredField("value");
    Class<?> valueType = value.getType();
    System.out.println("属性value的类型：" + valueType.getName()); // 属性value的类型：java.lang.Object

    // 方法上的泛型类型
    Method getValue = helperBean.getClass().getDeclaredMethod("getValue");
    Object invoke = getValue.invoke(helperBean);
    Class<?> invokeClass = invoke.getClass();
    System.out.println("方法getValue上的泛型类型：" + invokeClass.getName()); // 方法getValue上的泛型类型：java.lang.String
  }

}
