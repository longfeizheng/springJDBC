package com.merryyou.util;

import com.merryyou.base.AuthInfo;

import javax.servlet.http.HttpSession;

/**
 * Created on 2015/9/22 0022.
 *
 * @author zhenglongfei
 * @since 1.0
 */
public class SessionUtil {
    public static final String KEY_AUTH_INFO = "auth_info";

    public SessionUtil() {
    }

    public static void setAuthInfo(HttpSession session, AuthInfo info) {
        session.setAttribute("auth_info", info);
    }

    public static AuthInfo getAuthInfo(HttpSession session) {
        return (AuthInfo)session.getAttribute("auth_info");
    }
}

