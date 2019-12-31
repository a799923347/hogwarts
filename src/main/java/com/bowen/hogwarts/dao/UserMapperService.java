package com.bowen.hogwarts.dao;

import com.bowen.hogwarts.dao.mapper.UserMapper;
import com.bowen.hogwarts.dao.model.User;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @author zhaobaowen
 */
@Service
public class UserMapperService {

  @Resource
  private UserMapper userMapper;

  public User insert(User user) {
    userMapper.insert(user);
    return user;
  }

}
