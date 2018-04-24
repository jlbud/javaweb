package com.chen.ssm.service;

import com.chen.ssm.entity.User;

/**
 * com.chen.ssm.service
 * 作者      : 陈晓
 * 描述      :
 * 创建日期  : 2017/12/4
 * 修改日期  :
 */
public interface UserService {

  User login(User user);

  User getUserById(String id);

  void add(User user);

  void update(User user);
}
