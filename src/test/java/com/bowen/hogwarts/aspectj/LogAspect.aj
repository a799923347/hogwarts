package com.bowen.hogwarts.aspectj;

public aspect LogAspect {

  // 定义一个 PointCut，其名为 logPointcut
  // 该 PointCut 对应于指定 Hello 对象的 sayHello 方法
  pointcut logPointcut():execution(void Hello.sayHello());
  // 在 logPointcut 之后执行下面代码块
  after():logPointcut(){
    System.out.println("记录日志 ...");
  }

}
