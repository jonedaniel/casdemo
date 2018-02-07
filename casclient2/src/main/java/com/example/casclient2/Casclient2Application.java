package com.example.casclient2;

import net.unicon.cas.client.configuration.EnableCasClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableCasClient
@RestController
public class Casclient2Application {

	public static void main(String[] args) {
		SpringApplication.run(Casclient2Application.class, args);
	}


	@RequestMapping(method = RequestMethod.GET,value = "/main")
    public Object main() {
        return "welcome to our home page";
    }
}
