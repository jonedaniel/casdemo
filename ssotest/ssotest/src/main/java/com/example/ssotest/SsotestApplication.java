package com.example.ssotest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@SpringBootApplication
@Controller
public class SsotestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SsotestApplication.class, args);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/index")
	@ResponseBody
	public Object index() {
		return "hello,world";
	}

	@RequestMapping(method = RequestMethod.GET,value = "/setTGT")
	@ResponseBody
	public Object setTgt(HttpServletResponse response) {
		Cookie tgt = new Cookie("TGT", "123456789");
		response.addCookie(tgt);

		return true;
	}

	@RequestMapping(method = RequestMethod.GET,value = "/main")
	@ResponseBody
	public Object main() {
		return "this is main page";
	}

	@RequestMapping(method = RequestMethod.GET,value="/login")
	public String login() {
		return "login";
	}
}
