package com.example.ssoclient.controller;

import com.example.cascommon.util.UserContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;


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

    @RequestMapping(method = RequestMethod.GET,value = "/logout")
    @ResponseBody
    public Object logout() throws IOException {
        UserContext.removeSession();
        return true;
    }
}
