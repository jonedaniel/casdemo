package com.example.ssoclient1.filter;

import com.example.ssoclient1.util.CookieUtils;
import com.example.ssoclient1.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class SSOClientFilter implements Filter {

    @Autowired
    private RedisUtil redisUtil;

    @Value("${loginUrl}")
    private String loginUrl;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        // tgt检查
        String ticket = request.getParameter("ticket");
        if (!StringUtils.hasLength(ticket)) {
            ticket = CookieUtils.getCookieValue(request, "ticket");
        }
        //如果url中没有ticket或者cookie中没有ticket
        if (!StringUtils.hasLength(ticket) || !StringUtils.hasLength(redisUtil.get(ticket))) {
            //删除无效cookie
            CookieUtils.deleteCookie(request, response, "ticket");
            String queryString = request.getQueryString();
            response.sendRedirect(loginUrl + "?service=" + request.getRequestURL() + (StringUtils.hasLength(queryString) ? "/" + queryString : ""));
            filterChain.doFilter(request,response);
        } else {
            redisUtil.set(ticket, "ticket", 20L);
            filterChain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
