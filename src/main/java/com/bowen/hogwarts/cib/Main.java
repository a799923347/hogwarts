package com.bowen.hogwarts.cib;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;




/**
 * @author zhaobaowen
 */
public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String nextLine = sc.nextLine();
    int num;
    try {
      num = Integer.parseInt(nextLine);
    } catch (Exception e) {
      System.out.println("ERROR");
      return;
    }
    for (int i = num, j = num; i >= 0; i--, j++) {
      boolean left = isPalindrome(i);
      boolean right = isPalindrome(j);
      if (left) {
        System.out.println(i);
      }
      if (right) {
        System.out.println(j);
      }
      if (left || right) {
        return;
      }
    }
  }

  public static boolean isPalindrome(int num) {
    List<Integer> numList = new ArrayList<>();
    while (num / 10 != 0) {
      numList.add(num % 10);
      num = num / 10;
    }
    numList.add(num);
    for (int left = 0, right = numList.size() - 1; left <= right; left++, right--) {
      if (!numList.get(left).equals(numList.get(right))) {
        return false;
      }
    }
    return true;
  }
}
