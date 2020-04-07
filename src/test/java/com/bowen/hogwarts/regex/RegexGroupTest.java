package com.bowen.hogwarts.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.Test;

/**
 * @author zhaobaowen
 */
public class RegexGroupTest {

  @Test
  public void test() {
    Pattern pattern = Pattern.compile("(\\d+,)(\\d+)");
    String s = "123,456-34,345";
    Matcher m = pattern.matcher(s);
    while (m.find()) {
      System.out.println("m.group():" + m.group()); //打印所有

      System.out.println("m.group(1):" + m.group(1)); //打印数字的

      System.out.println("m.group(2):" + m.group(2)); //打印字母的
      System.out.println();
    }
    System.out.println("捕获个数:groupCount()=" + m.groupCount());
    System.out.println(Pattern.matches("(\\d+,)(\\d+)", "123,456"));
  }

}
