package com.bowen.hogwarts.reflection;

import java.lang.reflect.Method;
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

  @Test
  public void test2() {
    Class<Integer> c1 = int.class;//int 的类类型
    Class<String> c2 = String.class;//String类的类类型
    Class<Void> c3 = void.class;
    System.out.println(c1.getName());
    System.out.println(c2.getName());
    System.out.println(c2.getSimpleName());
    System.out.println(c3.getName());
  }

  @Test
  public void test3() {
    //要获取类的信息》》首先我们要获取类的类类型
    Class<ClassTypeAndReflectionTest> aClass = ClassTypeAndReflectionTest.class;
    //我们知道Object类是一切类的父类，所以我们传递的是哪个子类的对象，c就是该子类的类类型。
    //接下来我们要获取类的名称
    System.out.println("类的名称是:" + aClass.getName());
    /*
     *我们知道，万事万物都是对象，方法也是对象，是谁的对象呢？
     * 在java里面，方法是Method类的对象
     *一个成员方法就是一个Method的对象，那么Method就封装了对这个成员
     *方法的操作
     */
    //如果我们要获得所有的方法，可以用getMethods()方法，这个方法获取的是所有的Public的函数，包括父类继承而来的。如果我们要获取所有该类自己声明的方法，就可以用getDeclaredMethods()方法，这个方法是不问访问权限的。
    Method[] ms = aClass.getMethods();//c.getDeclaredMethods()
    //接下来我们拿到这些方法之后干什么？我们就可以获取这些方法的信息，比如方法的名字。
    //首先我们要循环遍历这些方法
    for (Method m : ms) {
      //然后可以得到方法的返回值类型的类类型
      Class<?> returnType = m.getReturnType();
      //得到方法的返回值类型的名字
      System.out.print(returnType.getName() + " ");
      //得到方法的名称
      System.out.print(m.getName() + "(");
      //获取参数类型--->得到的是参数列表的类型的类类型
      Class<?>[] parameterTypes = m.getParameterTypes();
      for (Class<?> parameterType : parameterTypes) {
        System.out.print(parameterType.getName() + ",");
      }
      System.out.println(")");
    }
  }

}
