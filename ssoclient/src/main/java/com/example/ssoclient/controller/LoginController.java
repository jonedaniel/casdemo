package com.example.ssoclient.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    @RequestMapping(method = RequestMethod.GET,value = "/main")
    public String login() {
        return "main";
    }
}
