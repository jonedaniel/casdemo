package com.example.ssotest.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TestFilter implements Filter {

    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        // 获取service url
        String service = "";
        String lt = "";
        String strings = request.getQueryString();
        if (StringUtils.hasLength(strings)) {
            String[] queryStrings = strings.split("&");
            for (String queryString : queryStrings) {
                if (queryString.startsWith("service")) {
                    service = queryString.split("=")[1];
                }
                if (queryString.startsWith("lt")) {
                    lt = queryString.split("=")[1];
                }
            }
        }
        //cookie检查
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("TGT")) {
                System.out.println(cookie.getValue());
            }
        }

        LOG.error("SERVICE:{},LT:{}",service,lt);

        if (StringUtils.hasLength(service)) {
            response.sendRedirect(service);
        }


        filterChain.doFilter(request, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
