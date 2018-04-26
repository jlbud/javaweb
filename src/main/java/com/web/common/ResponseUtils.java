package com.web.common;

import com.web.entity.respo.ResponseBean;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * HttpServletResponse返回数据格式化
 */
public class ResponseUtils {

    public static void renderJson(HttpServletResponse response, ResponseBean bean) {
        render(response, "text/plain;charset=UTF-8", JsonUtils.responJson(bean));
    }


    /**
     * 发送的内容,使用UTF-8编码
     *
     * @param response
     * @param contentType
     * @param text
     */
    private static void render(HttpServletResponse response, String contentType, String text) {
        response.setContentType(contentType);
        response.setCharacterEncoding("utf-8");
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        try {
            response.getWriter().write(text);
        } catch (IOException e) {
        }
    }
}

