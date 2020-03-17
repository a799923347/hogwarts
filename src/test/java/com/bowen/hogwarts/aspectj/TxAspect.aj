package com.bowen.hogwarts.aspectj;

public aspect TxAspect {

  // 指定执行 Hello.sayHello() 方法时执行下面代码块
  // 需要使用 AspectJ 的 ajc 命令同时编译 Hello 和 TxAspect 文件
  void around():call(void Hello.sayHello()){
    System.out.println("开始事务 ...");
    proceed();
    System.out.println("事务结束 ...");
  }

}
