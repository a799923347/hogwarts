package com.bowen.hogwarts.proxy;

import java.lang.reflect.Proxy;
import org.junit.jupiter.api.Test;

public class MyProxyTest {

  @Test
  public void test() {
    Subject subject = new SubjectImpl();
    MyInvocationHandler myHandler = new MyInvocationHandler(subject);
    ClassLoader classLoader = myHandler.getClass().getClassLoader();
    Class<?>[] interfaces = subject.getClass().getInterfaces();

    Subject subjectProxy = (Subject) Proxy.newProxyInstance(classLoader, interfaces, myHandler);
    System.out.println("对象：" + subjectProxy.getClass());
    String say = subjectProxy.sayHello("xiaoming");
    System.out.println(say);
  }
}
