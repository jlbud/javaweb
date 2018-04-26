package com.web.service;

import com.web.entity.requo.UserBean;

public interface UserService {

  UserBean login(UserBean user);

  UserBean getUserById(String id);

  void add(UserBean user);

  void update(UserBean user);
}
