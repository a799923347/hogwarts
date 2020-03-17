package com.bowen.hogwarts.priorityqueue;

import java.util.PriorityQueue;
import org.junit.Test;

/**
 * @author zhaobaowen
 */
public class PriorityQueueTest {

  @Test
  public void test() {
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
    priorityQueue.add(3);
    priorityQueue.add(1);
    priorityQueue.add(5);
    priorityQueue.add(9);
    priorityQueue.add(2);
    System.out.println(priorityQueue.poll());
  }

  @Test
  public void test2() {
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((num1, num2) -> num2 - num1);
    priorityQueue.add(3);
    priorityQueue.add(1);
    priorityQueue.add(5);
    priorityQueue.add(9);
    priorityQueue.add(2);
    System.out.println(priorityQueue.poll());
  }

}
