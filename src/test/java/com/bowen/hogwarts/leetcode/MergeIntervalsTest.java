package com.bowen.hogwarts.leetcode;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.Test;

public class MergeIntervalsTest {

  @Test
  public void merge() {
    int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}, {5, 8}};
    int[][] merge = new MergeIntervals().merge(intervals);
    Arrays.stream(merge).forEach(ele -> System.out.println(Arrays.toString(ele)));
  }

  @Test
  public void merge2() {
    int[][] intervals = {{1, 4}, {4, 5}};
    int[][] merge = new MergeIntervals().merge(intervals);
    Arrays.stream(merge).forEach(ele -> System.out.println(Arrays.toString(ele)));
  }

  @Test
  public void merge3() {
    int[][] intervals = {{1, 4}};
    int[][] merge = new MergeIntervals().merge(intervals);
    Arrays.stream(merge).forEach(ele -> System.out.println(Arrays.toString(ele)));
  }

  @Test
  public void merge4() {
    int[][] intervals = {{0, 4}};
    int[][] merge = new MergeIntervals().merge(intervals);
    Arrays.stream(merge).forEach(ele -> System.out.println(Arrays.toString(ele)));
  }
}