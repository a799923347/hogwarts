package com.bowen.hogwarts.leetcode;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class StringCheckInclusionTest {

  @Test
  public void test1() {
    StringCheckInclusion stringCheckInclusion = new StringCheckInclusion();
    boolean inclusion = stringCheckInclusion.checkInclusion("ab", "eidbaooo");
    System.out.println(inclusion);
    assert inclusion;
  }

  @Test
  public void test2() {
    StringCheckInclusion stringCheckInclusion = new StringCheckInclusion();
    boolean inclusion = stringCheckInclusion.checkInclusion("ab", "eidboaoo");
    System.out.println(inclusion);
    assert !inclusion;
  }

  @Test
  public void test3() {
    List<String> list = new ArrayList<>(8);
    list.add("abc");
    System.out.println(list.size());
  }
}