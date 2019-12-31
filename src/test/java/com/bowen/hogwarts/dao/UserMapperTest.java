package com.bowen.hogwarts.dao;

import com.bowen.hogwarts.HogwartsApplication;
import com.bowen.hogwarts.dao.model.User;
import javax.annotation.Resource;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author zhaobaowen
 */
@SpringBootTest(classes = HogwartsApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class UserMapperTest {

  @Resource
  private UserMapperService userMapperService;

  @Ignore
  @Test
  public void testInsert() {
    User user = User.builder().name("wangwu").age(24).idNo("67453018375").gender("male").build();
    User insert = userMapperService.insert(user);
    assert insert.getId() != null;
  }
}
