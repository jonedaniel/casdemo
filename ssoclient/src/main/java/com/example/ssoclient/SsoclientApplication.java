package com.example.ssoclient;

import com.example.cascommon.config.FilterConfiguration;
import net.unicon.cas.client.configuration.EnableCasClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EnableCasClient
@Import(FilterConfiguration.class)
public class SsoclientApplication  {

	public static void main(String[] args) {
		SpringApplication.run(SsoclientApplication.class, args);
	}


}
