package com.web.common;

import com.alibaba.fastjson.JSON;
import com.web.entity.respo.RespFeedBackBean;
import com.web.entity.respo.RespFeedBackListBean;
import com.web.entity.respo.RespUserBean;
import com.web.entity.respo.ResponseBean;

public class JsonUtils {

    public static String responJson(ResponseBean bean) {
        if (bean instanceof RespFeedBackBean) {
            return JSON.toJSONString((RespFeedBackBean) bean);
        } else if (bean instanceof RespUserBean) {
            return JSON.toJSONString((RespUserBean) bean);
        } else if (bean instanceof RespFeedBackListBean) {
            return JSON.toJSONString((RespFeedBackListBean) bean);
        }
        return null;
    }

}
