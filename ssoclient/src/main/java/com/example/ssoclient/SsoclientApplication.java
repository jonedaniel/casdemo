package com.example.ssoclient;

import net.unicon.cas.client.configuration.CasClientConfigurerAdapter;
import net.unicon.cas.client.configuration.EnableCasClient;
import org.jasig.cas.client.session.SingleSignOutFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.HashMap;

@SpringBootApplication
@EnableCasClient
public class SsoclientApplication  {

	public static void main(String[] args) {
		SpringApplication.run(SsoclientApplication.class, args);
	}


}
