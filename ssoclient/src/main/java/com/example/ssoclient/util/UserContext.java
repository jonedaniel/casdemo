package com.example.ssoclient.util;

import org.jasig.cas.client.authentication.AttributePrincipal;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class UserContext {

    public static HttpServletRequest getRequest() {
        return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
    }

    public static HttpSession getSession() {
        return getRequest().getSession();
    }

    public static String getUsername() {
        return ((AttributePrincipal)getRequest().getUserPrincipal()).getName();
    }
}
