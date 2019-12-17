package com.bowen.hogwarts.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author zhaobaowen
 */
public class MyInvocationHandler implements InvocationHandler {

  private Object object;

  public MyInvocationHandler(Object object) {
    this.object = object;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    System.out.println("调用方法之前。。。");
    System.out.println("调用的方法：" + method);
    Object result = method.invoke(object, args);
    System.out.println("调用结束");
    return result;
  }
}
