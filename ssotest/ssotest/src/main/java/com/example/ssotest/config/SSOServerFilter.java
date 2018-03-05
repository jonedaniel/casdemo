package com.example.ssotest.config;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class SSOServerFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String queryString = request.getQueryString();
        String service;
        String tgt;
        if (StringUtils.hasLength(queryString)) {
            String[] split = queryString.split("&");
            for (String s : split) {
                if (s.startsWith("service")) {
                    service = s.split("=")[1];
                }
                if (s.startsWith("tgt")) {
                    tgt = s.split("=")[1];
                }
            }
        }
        //查询redis是否缓存有tgt

    }

    @Override
    public void destroy() {

    }
}
