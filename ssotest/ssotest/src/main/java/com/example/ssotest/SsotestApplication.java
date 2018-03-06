package com.example.ssotest;

import com.example.ssotest.util.CookieUtils;
import com.example.ssotest.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.spec.PSSParameterSpec;
import java.util.Arrays;
import java.util.UUID;

@SpringBootApplication
@Controller
public class SsotestApplication {

    @Value("${serverUrl}")
    private String serverUrl;
    @Autowired
    private RedisUtil redisUtil;

    public static void main(String[] args) {
        SpringApplication.run(SsotestApplication.class, args);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/index")
    @ResponseBody
    public Object index() {
        return "hello,world";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/setTGT")
    @ResponseBody
    public Object setTgt(HttpServletRequest request, HttpServletResponse response) {
        System.out.println(request.getParameter("TGT"));
        Arrays.stream(request.getCookies()).forEach(x -> System.out.println(x.getValue()));
        Cookie tgt = new Cookie("TGT", "123456789");
        response.addCookie(tgt);

        return true;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/main")
    @ResponseBody
    public Object main() {
        return "this is main page";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/main")
    @ResponseBody
    public Object mainP() {
        return "this is main pageP";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public String login(Model model, HttpServletRequest request) {
        String service = request.getParameter("service");
        System.out.println(service);
        model.addAttribute("service", service);
        return "login";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public Object login(String username, String password, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if ("zmh".equals(username) && "123".equals(password)) {
            String service = request.getParameter("service");

            if (StringUtils.hasLength(service)) {
                String ticket = UUID.randomUUID().toString().substring(0, 6);
                redisUtil.set(ticket, "", 1000 * 10L);
                String[] split = service.split("/");
                StringBuilder domain = new StringBuilder(10);
                domain.append(split[2].split(":")[0]);
                System.out.println(domain);
                CookieUtils.addCookie(response, "ticket", ticket, 1000 * 10, new String(domain));
                return "redirect:" + service;
            }
        }
        return "redirect:" + serverUrl + "/main";
    }
}
