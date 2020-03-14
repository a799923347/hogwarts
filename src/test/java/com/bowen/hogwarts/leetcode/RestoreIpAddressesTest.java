package com.bowen.hogwarts.leetcode;

import static org.junit.Assert.*;

import java.util.List;
import org.junit.Test;

public class RestoreIpAddressesTest {

  @Test
  public void restoreIpAddresses() {
    List<String> list = new RestoreIpAddresses().restoreIpAddresses("25525511135");
    System.out.println(list);
  }

  @Test
  public void restoreIpAddresses2() {
    List<String> list = new RestoreIpAddresses().restoreIpAddresses("255255111135");
    System.out.println(list);
  }

  @Test
  public void restoreIpAddresses3() {
    List<String> list = new RestoreIpAddresses().restoreIpAddresses("0000");
    System.out.println(list);
  }

  @Test
  public void restoreIpAddresses4() {
    List<String> list = new RestoreIpAddresses().restoreIpAddresses("010010");
    System.out.println(list);
  }

  @Test
  public void restoreIpAddresses5() {
    List<String> list = new RestoreIpAddresses().restoreIpAddresses("0");
    System.out.println(list);
  }

  @Test
  public void restoreIpAddresses6() {
    List<String> list = new RestoreIpAddresses().restoreIpAddresses("0279245587303");
    System.out.println(list);
  }
}