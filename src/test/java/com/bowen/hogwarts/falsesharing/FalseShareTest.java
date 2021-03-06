package com.bowen.hogwarts.falsesharing;

/**
 * 参考：https://www.cnblogs.com/cyfonly/p/5800758.html
 *
 * @author zhaobaowen
 */
public class FalseShareTest implements Runnable {

  public static int NUM_THREADS = 4;
  public final static long ITERATIONS = 500L * 1000L * 1000L;
  private final int arrayIndex;
  private static VolatileLong[] longs;
  public static long SUM_TIME = 0L;

  public FalseShareTest(final int arrayIndex) {
    this.arrayIndex = arrayIndex;
  }

  public static void main(final String[] args) throws Exception {
    Thread.sleep(10000);
    for (int j = 0; j < 10; j++) {
      System.out.println(j);
      if (args.length == 1) {
        NUM_THREADS = Integer.parseInt(args[0]);
      }
      longs = new VolatileLong[NUM_THREADS];
      for (int i = 0; i < longs.length; i++) {
        longs[i] = new VolatileLong();
      }
      final long start = System.nanoTime();
      runTest();
      final long end = System.nanoTime();
      SUM_TIME += end - start;
    }
    System.out.println("平均耗时：" + SUM_TIME / 10);
  }

  private static void runTest() throws InterruptedException {
    Thread[] threads = new Thread[NUM_THREADS];
    for (int i = 0; i < threads.length; i++) {
      threads[i] = new Thread(new FalseShareTest(i));
    }
    for (Thread t : threads) {
      t.start();
    }
    for (Thread t : threads) {
      t.join();
    }
  }

  public void run() {
    long i = ITERATIONS + 1;
    while (0 != --i) {
      longs[arrayIndex].value = i;
    }
  }

  public final static class VolatileLong {

    public volatile long value = 0L;
    // 缓存行大小为64个字节，long类型为8个字节，
    // 这里应该认为是32位系统，32位系统中对象头标记字段 32/8 = 4 个字节，类型指针占 4 个字节
    // 所以填充 6 个 long 型字段，对象总大小即为 8 + 4 + 4 + 8 * 6 = 64 个字节
    // public long p1, p2, p3, p4, p5, p6;     //屏蔽此行
  }
}
