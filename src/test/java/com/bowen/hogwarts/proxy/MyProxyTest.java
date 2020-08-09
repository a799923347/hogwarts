package com.bowen.hogwarts.proxy;

import java.lang.reflect.Proxy;
import org.junit.Test;

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

  @Test
  public void test_hashcode() throws InterruptedException {
    MyInvocationHandler myHandler = new MyInvocationHandler(new SubjectImpl());
    ClassLoader classLoader = myHandler.getClass().getClassLoader();
    Class<?>[] interfaces = Subject.class.getInterfaces();

    Object subjectProxy = Proxy.newProxyInstance(this.getClass().getClassLoader(), interfaces, myHandler);
    System.out.println("proxy object hashcode:" + subjectProxy.hashCode());
    Subject subject = new SubjectImpl();
    System.out.println("origin object hashcode:" + subject.hashCode());

    MyInvocationHandler myHandler2 = new MyInvocationHandler(subject);
    Object subjectProxy2 = Proxy.newProxyInstance(this.getClass().getClassLoader(), interfaces, myHandler2);
    System.out.println("proxy object2 hashcode:" + subjectProxy2.hashCode());

  }
}
