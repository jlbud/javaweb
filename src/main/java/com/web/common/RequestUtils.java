package com.web.common;

import javax.servlet.http.HttpServletRequest;

/**
 * RequestUtils
 */
public class RequestUtils {

    /**
     * get token
     *
     * @param request
     * @return
     */
    public static String getHeader(HttpServletRequest request) {
        return request.getHeader("X-AccessToken");
    }

}

