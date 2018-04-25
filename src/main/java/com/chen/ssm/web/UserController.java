package com.chen.ssm.web;

import com.chen.ssm.entity.User;
import com.chen.ssm.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * com.chen.ssm.web
 * 作者      : 陈晓
 * 描述      :
 * 创建日期  : 2017/12/4
 * 修改日期  :
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @ResponseBody
    @RequestMapping("/register")
    public String test() {
        return "list";
    }

    @ResponseBody
    @RequestMapping("/index")
    public String index() {
        return "login";
    }

    @ResponseBody
    @RequestMapping("/login")
    public String login(User user, HttpServletRequest request) {
        user.setId(7);
        user.setEmail("1118632@163.com");
        user.setPassword("f1dsadsa");
        user.setPhone("fdads1afdsa");
        user.setSex("fdafsafd1safdsa");
        user.setSfz("fdadsa1");
        user.setTruename("fd1a");
        user.setUsername("fda1fdafdsa");
        User loginUser = userService.login(user);
        if (loginUser != null) {
            request.getSession().setAttribute("currentUser", loginUser);
            return "loginSuccess";
        }
        request.getSession().setAttribute("message", "用户名或密码有误！！！");
        System.out.println(loginUser.getUsername());
        return "login";
    }

    @RequestMapping("/search")
    public String search() {
        return "login";
    }
}
