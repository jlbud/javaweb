package com.web.dao;

import com.web.entity.dbo.UserBean;


public interface IUserDao {

    UserBean login(UserBean user);

    UserBean selectByPrimaryKey(Integer id);

    UserBean selectByPrimaryPhone(String phone);

    int deleteByPrimaryKey(Integer id);

    int insert(UserBean record);

    int insertSelective(UserBean record);

    int updateByPrimaryKeySelective(UserBean record);

    int updateByPrimaryKey(UserBean record);
}