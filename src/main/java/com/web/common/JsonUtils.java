package com.web.common;

import com.alibaba.fastjson.JSON;
import com.web.entity.respo.RespFeedBackBean;
import com.web.entity.respo.ResponseBean;

public class JsonUtils {

    public static String responJson(ResponseBean bean) {
        if (bean instanceof RespFeedBackBean) {
            RespFeedBackBean respFeedBackBean = (RespFeedBackBean) bean;
            return JSON.toJSONString(respFeedBackBean);
        }
        return null;
    }

}
