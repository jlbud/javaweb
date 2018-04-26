package com.web.service.impl;

import com.web.dao.IUserDao;
import com.web.entity.requo.UserBean;
import com.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class IUserService implements UserService {

  @Autowired
  private IUserDao userDao;


  public UserBean login(UserBean user) {
//    return userDao.login(user);
    userDao.insert(user);
    return user;
  }

  public UserBean getUserById(String id) {
    return userDao.selectByPrimaryKey(Integer.parseInt(id));
  }

  public void add(UserBean user) {

  }

  public void update(UserBean user) {

  }
}
