package com.bowen.hogwarts.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @author zhaobaowen
 */
public class CountTask extends RecursiveTask<Integer> {

  private static final int threshold = 2;
  private int start;
  private int end;

  public CountTask(int start, int end) {
    this.start = start;
    this.end = end;
  }

  @Override
  protected Integer compute() {
    int sum = 0;
    boolean canCompute = (end - start) <= threshold;
    if (canCompute) {
      for (int i = start; i <= end; i++) {
        sum += i;
      }
    } else {
      int middle = (start + end) / 2;
      CountTask leftTask = new CountTask(start, middle);
      CountTask rightTask = new CountTask(middle + 1, end);

      // 执行子任务
      invokeAll(leftTask, rightTask);

      // 等待子任务执行结果
      Integer leftResult = leftTask.join();
      Integer rightResult = rightTask.join();

      // 合并子任务
      sum = leftResult + rightResult;
      // throw new RuntimeException("测试异常...");
    }
    return sum;
  }

  public static void main(String[] args) {
    ForkJoinPool forkJoinPool = new ForkJoinPool();
    CountTask countTask = new CountTask(1, 4);
    ForkJoinTask<Integer> submit = forkJoinPool.submit(countTask);
    try {
      if (submit.isCompletedAbnormally()) {
        System.out.println("执行异常了");
        // System.out.println("执行异常了:" + submit.getException().getMessage());
      } else {
        System.out.println(submit.get());
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
      e.printStackTrace();
    }
  }
}
