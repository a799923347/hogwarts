package com.bowen.hogwarts.rule;

import static org.hamcrest.Matchers.isA;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * @author zhaobaowen
 */
public class ExceptedExceptionTest {

  @Rule
  public final ExpectedException thrown = ExpectedException.none();

  @Test
  public void givenIllegalArgument_whenExceptionThrown_MessageAndCauseMatches() {
    thrown.expect(IllegalArgumentException.class);
    thrown.expectCause(isA(NullPointerException.class));
    thrown.expectMessage("This is illegal");

    throw new IllegalArgumentException("This is illegal", new NullPointerException());
  }

}
