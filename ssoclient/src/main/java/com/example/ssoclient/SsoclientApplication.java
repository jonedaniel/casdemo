package com.example.ssoclient;

import net.unicon.cas.client.configuration.EnableCasClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableCasClient
public class SsoclientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SsoclientApplication.class, args);
	}
}
