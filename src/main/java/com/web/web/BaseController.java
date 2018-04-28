package com.web.web;

import com.web.common.RequestUtils;
import com.web.common.ResponseUtils;
import com.web.entity.respo.RespUserBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseController {

    /**
     * check token
     *
     * @param request
     * @return
     */
    protected boolean checkToken(HttpServletRequest request, HttpServletResponse response) {
        String token = RequestUtils.getHeader(request);
        if (token != null && token != "") {
            //todo check token
            return true;
        } else {
            RespUserBean respUserBean = new RespUserBean();
            respUserBean.setSuccess("-1");
            ResponseUtils.renderJson(response, respUserBean);
            return false;
        }
    }

}
