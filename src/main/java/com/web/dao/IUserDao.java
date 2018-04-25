package com.web.dao;

import com.web.entity.User;


public interface IUserDao {

    User login(User user);

    User selectByPrimaryKey(Integer id);

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}