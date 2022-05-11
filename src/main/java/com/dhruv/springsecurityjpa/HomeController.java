package com.dhruv.springsecurityjpa;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home(){
        return "String 1";
    }

    @GetMapping("/user")
    public String homeUser(){
        return "String user";
    }

    @GetMapping("/admin")
    public String adminUser(){
        return "Admin user";
    }

}
