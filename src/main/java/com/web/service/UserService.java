package com.web.service;

import com.web.entity.User;

public interface UserService {

  User login(User user);

  User getUserById(String id);

  void add(User user);

  void update(User user);
}
