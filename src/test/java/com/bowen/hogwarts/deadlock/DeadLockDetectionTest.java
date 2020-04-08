package com.bowen.hogwarts.deadlock;

/**
 * @author zhaobaowen
 */
public class DeadLockDetectionTest {

  public static void main(String[] args) {
    final Object a = new Object();
    final Object b = new Object();
    Thread threadA = new Thread(new Runnable() {
      public void run() {
        synchronized (a) {
          try {
            System.out.println("now i in threadA-locka");
            Thread.sleep(1000L);
            synchronized (b) {
              System.out.println("now i in threadA-lockb");
            }
          } catch (Exception e) {
            // ignore
          }
        }
      }
    });

    Thread threadB = new Thread(new Runnable() {
      public void run() {
        synchronized (b) {
          try {
            System.out.println("now i in threadB-lockb");
            Thread.sleep(1000L);
            synchronized (a) {
              System.out.println("now i in threadB-locka");
            }
          } catch (Exception e) {
            // ignore
          }
        }
      }
    });

    threadA.start();
    threadB.start();
  }


}
