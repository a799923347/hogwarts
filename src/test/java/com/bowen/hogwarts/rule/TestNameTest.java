package com.bowen.hogwarts.rule;

import static org.junit.Assert.assertEquals;

import lombok.extern.slf4j.Slf4j;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

/**
 * @author zhaobaowen
 */
@Slf4j
public class TestNameTest {

  @Rule
  public TestName name = new TestName();

  @Test
  public void givenAddition_whenPrintingTestName_thenTestNameIsDisplayed() {
    log.info("Executing: {}", name.getMethodName());
    assertEquals("givenAddition_whenPrintingTestName_thenTestNameIsDisplayed",
        name.getMethodName());
  }

}
