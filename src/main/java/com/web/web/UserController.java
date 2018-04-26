package com.web.web;

import com.web.common.ResponseUtils;
import com.web.entity.dbo.UserBean;
import com.web.entity.respo.RespFeedBackBean;
import com.web.entity.respo.RespUserBean;
import com.web.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * create by kevin
 * <p/>
 * about user
 */

@Controller
@RequestMapping("/xiaoshi/user")
public class UserController {

    @Resource
    private UserService userService;

    /**
     * register V1.0
     *
     * @param userBean
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/register", method = RequestMethod.POST, consumes = "application/json")
    public void register(@RequestBody UserBean userBean, HttpServletResponse response) {
        boolean isSuccess = userService.register(userBean);
        if (isSuccess) {
            RespFeedBackBean backBean = new RespFeedBackBean();
            backBean.setMessage("pass");
            backBean.setSuccess("0");
            ResponseUtils.renderJson(response, backBean);
        } else {
            RespFeedBackBean backBean = new RespFeedBackBean();
            backBean.setMessage("fail");
            backBean.setSuccess("-1");
            backBean.setData("register fail");
            ResponseUtils.renderJson(response, backBean);

        }
    }

    /**
     * login V1.0
     *
     * @param userBean
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST, consumes = "application/json")
    public void login(@RequestBody UserBean userBean, HttpServletResponse response) {
        if (userBean == null || userBean.getPhone().equals("") || userBean.getPhone() == null) {
            RespUserBean respUserBean = new RespUserBean();
            respUserBean.setSuccess("-1");
            ResponseUtils.renderJson(response, respUserBean);
        } else {
            UserBean bean = userService.login(userBean);
            if (bean == null) {
                RespUserBean respUserBean = new RespUserBean();
                respUserBean.setSuccess("-1");
                ResponseUtils.renderJson(response, respUserBean);
            } else {
                RespUserBean respUserBean = new RespUserBean();
                respUserBean.setSuccess("0");
                respUserBean.setData(bean);
                ResponseUtils.renderJson(response, respUserBean);
            }
        }
    }

    @RequestMapping("/search")
    public String search() {
        return "login";
    }
}
