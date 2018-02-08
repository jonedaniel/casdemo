package com.example.ssoclient.controller;

import com.example.ssoclient.util.UserContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class MainController {

    @Value("${logoutUrl}")
    private String logoutUrl;

    @RequestMapping(method = RequestMethod.GET,value = "/main")
    public String main(Model model) {
        model.addAttribute("username", UserContext.getUsername());
        model.addAttribute("logoutUrl", logoutUrl);
        return "main";
    }

}
