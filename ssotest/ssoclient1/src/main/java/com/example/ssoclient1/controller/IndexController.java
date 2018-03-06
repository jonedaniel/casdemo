package com.example.ssoclient1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @RequestMapping(method = RequestMethod.GET,value = "/index")
    public Object index() {
        return "this is client 1";
    }
}
