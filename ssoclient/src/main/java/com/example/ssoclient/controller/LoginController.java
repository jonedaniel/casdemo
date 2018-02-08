package com.example.ssoclient.controller;

import com.example.ssoclient.util.UserContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class LoginController {

    @RequestMapping(method = RequestMethod.GET,value = "/main")
    public String main(Model model) {
        model.addAttribute("username", UserContext.getUsername());
        return "main";
    }
}
