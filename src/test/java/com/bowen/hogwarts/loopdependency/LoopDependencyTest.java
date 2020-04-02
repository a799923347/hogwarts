package com.bowen.hogwarts.loopdependency;

import com.bowen.hogwarts.HogwartsApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author zhaobaowen
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = HogwartsApplication.class)
public class LoopDependencyTest {

  @Test
  public void givenCircularDependency_whenConstructorInjection_thenItFails() {
    // Empty test; we just want the context to load
  }
}
