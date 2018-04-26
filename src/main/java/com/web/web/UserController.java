package com.web.web;

import com.web.common.JsonUtils;
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

/**
 * Create by kevin
 * <p/>
 * 用户
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
    public String register(@RequestBody UserBean userBean) {
        boolean isSuccess = userService.register(userBean);
        if (isSuccess) {
            RespFeedBackBean backBean = new RespFeedBackBean();
            backBean.setMessage("pass");
            backBean.setSuccess("0");
            return JsonUtils.responJson(backBean);
        } else {
            RespFeedBackBean backBean = new RespFeedBackBean();
            backBean.setMessage("fail");
            backBean.setSuccess("-1");
            backBean.setData("register fail");
            return JsonUtils.responJson(backBean);
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
    public String login(@RequestBody UserBean userBean) {
        if (userBean == null || userBean.getPhone().equals("") || userBean.getPhone() == null) {
            RespUserBean respUserBean = new RespUserBean();
            respUserBean.setSuccess("-1");
            return JsonUtils.responJson(respUserBean);
        } else {
            UserBean bean = userService.login(userBean);
            if (bean == null) {
                RespUserBean respUserBean = new RespUserBean();
                respUserBean.setSuccess("-1");
                return JsonUtils.responJson(respUserBean);
            } else {
                RespUserBean respUserBean = new RespUserBean();
                respUserBean.setSuccess("0");
                respUserBean.setData(bean);
                return JsonUtils.responJson(respUserBean);
            }
        }
    }

    @RequestMapping("/search")
    public String search() {
        return "login";
    }
}
