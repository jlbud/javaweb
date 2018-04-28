package com.web.service.impl;

import com.web.dao.IUserDao;
import com.web.entity.dbo.UserBean;
import com.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class IUserService implements UserService {

    @Autowired
    private IUserDao userDao;

    @Override
    public boolean register(UserBean user) {
        if (user == null || user.getPhoneNumber() == null || user.getPhoneNumber().equals("")) {
            return false;
        } else {
            UserBean bean = getUserByPhone(user.getPhoneNumber());
            if (bean != null) {
                return false;
            } else {
                user.setCreateTime(String.valueOf(System.currentTimeMillis()));
                userDao.insert(user);
                return true;
            }
        }
    }

    @Override
    public UserBean login(UserBean user) {
        UserBean bean = getUserByPhone(user.getPhoneNumber());
        if (bean == null) {
            return null;
        } else {
            return bean;
        }
    }

    @Override
    public UserBean getUserById(String id) {
        return userDao.selectByPrimaryKey(Integer.parseInt(id));
    }

    @Override
    public UserBean getUserByPhone(String phone) {
        return userDao.selectByPrimaryPhone(phone);
    }

    @Override
    public void add(UserBean user) {

    }

    @Override
    public void update(UserBean user) {

    }
}
