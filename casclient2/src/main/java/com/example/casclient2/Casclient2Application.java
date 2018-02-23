package com.example.casclient2;

import com.example.cascommon.config.FilterConfiguration;
import com.example.cascommon.util.UserContext;
import net.unicon.cas.client.configuration.EnableCasClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@SpringBootApplication
@EnableCasClient
@Controller
@Import(FilterConfiguration.class)
public class Casclient2Application {

    @Value("${logoutUrl}")
    private String logoutUrl;

	public static void main(String[] args) {
		SpringApplication.run(Casclient2Application.class, args);
	}

	@RequestMapping(method = RequestMethod.GET,value = "/main")
    public Object main(Model model) {
        model.addAttribute("logoutUrl",logoutUrl);
        model.addAttribute("username", UserContext.getUsername());
        return "main";
    }

    @RequestMapping(method = RequestMethod.GET,value = "/logout")
    @ResponseBody
    public Object logout() throws IOException {
        System.out.println(UserContext.getUsername());
        System.out.println(UserContext.getSession());
        UserContext.removeSession();
        return true;
    }
}
