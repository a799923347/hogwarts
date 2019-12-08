package com.bowen.hogwarts.leetcode;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Stack;
import org.junit.jupiter.api.Test;

class BracketIsValidTest {

  @Test
  void testStack() {
    Stack<String> strings = new Stack<>();
    strings.push("(");
    strings.push(")");
  }

  @Test
  void isValid() {
    boolean valid = new BracketIsValid().isValid("()");
    System.out.println(valid);
    assertTrue(valid);
  }

  @Test
  void isValid2() {
    boolean valid = new BracketIsValid().isValid("()[]{}");
    System.out.println(valid);
    assertTrue(valid);
  }

  @Test
  void isValid3() {
    boolean valid = new BracketIsValid().isValid("(]");
    System.out.println(valid);
    assertFalse(valid);
  }

  @Test
  void isValid4() {
    boolean valid = new BracketIsValid().isValid("{[]}");
    System.out.println(valid);
    assertTrue(valid);
  }

  @Test
  void isValid5() {
    boolean valid = new BracketIsValid().isValid("([)");
    System.out.println(valid);
    assertFalse(valid);
  }
}