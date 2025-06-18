package com.thirteenth.project.springmvcsecurity.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/loginpage")
    public String getLoginPage() {
        return "login-page";
    }

    @GetMapping("/management")
    public String getManagement() {
        return "management";
    }

    @GetMapping("/system")
    public String getSystem() {
        return "system";
    }

}
