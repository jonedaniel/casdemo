package com.example.cascommon.config;

import org.jasig.cas.client.session.SingleSignOutFilter;
import org.jasig.cas.client.session.SingleSignOutHttpSessionListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

/**
 * Title: FileterConfiguration
 * Description: FileterConfiguration
 * Copyright: Copyright (c) 2018
 * Company:ps
 *
 * @author zhaomenghui
 * @version 1.0
 */
@Configuration
public class FilterConfiguration {

    @Value("${cas.server-url-prefix}")
    private String prefixUrl;

    /**
     * CAS logoutFilter需要配置 Filter与listener
     *
     * @return FilterRegistrationBean
     * @author zhaomenghui
     * @date 2018/1/24,14:36
     */
    @Bean
    public FilterRegistrationBean someFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(singleSignOutFilter());
        registration.addUrlPatterns("/*");
        registration.setName("singleSignOutFilter");
        HashMap<String, String> initParamMap = new HashMap<>();
        initParamMap.put("casServerUrlPrefix", prefixUrl);
        registration.setInitParameters(initParamMap);
        return registration;
    }

    /**
     * 将单点登出Listener注入Spring
     *
     * @author zhaomenghui
     * @date 2018/1/24,14:36
     */
    @Bean
    public ServletListenerRegistrationBean<SingleSignOutHttpSessionListener> servletListenerRegistrationBean() {
        ServletListenerRegistrationBean<SingleSignOutHttpSessionListener> registration = new ServletListenerRegistrationBean<SingleSignOutHttpSessionListener>();
        registration.setListener(singleSignOutHttpSessionListener());
        return registration;
    }


    /**
     * 定义单点登出Filter
     *
     * @return SingleSignOutFilter
     * @author zhaomenghui
     * @date 2018/1/24,14:36
     */
    @Bean
    public SingleSignOutFilter singleSignOutFilter() {
        return new SingleSignOutFilter();
    }

    /**
     * 定义单点登出Listener
     *
     * @return SingleSignOutHttpSessionListener
     * @author zhaomenghui
     * @date 2018/2/9 15:37
     */
    @Bean
    public SingleSignOutHttpSessionListener singleSignOutHttpSessionListener() {
        return new SingleSignOutHttpSessionListener();
    }
}