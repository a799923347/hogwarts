package com.bowen.hogwarts.colllection;

import com.google.common.collect.Lists;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.junit.Test;

/**
 * @author zhaobaowen
 */
public class ListStreamTest {


  @Test
  public void test_EMPTY_LIST_STREAM() {
    List<String> list = null;
    List<String> collect = Optional.ofNullable(list).orElse(Lists.newArrayList())
        .stream()
        .map(item -> {
          System.out.println("hahaha" + item);
          return "aaa";
        }).collect(Collectors.toList());
  }
}
