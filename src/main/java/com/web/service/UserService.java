package com.web.service;

import com.web.entity.dbo.UserBean;

public interface UserService {

  UserBean login(UserBean user);

  boolean register(UserBean user);

  UserBean getUserById(String id);

  UserBean getUserByPhone(String phone);

  void add(UserBean user);

  void update(UserBean user);
}
