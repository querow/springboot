package com.zy.springboottest.modules.account.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class AccountController {
    @GetMapping("/register")
    public String registerPage(){
        return "indexSimple";
    }
    @GetMapping("/login")
    public String loginPage(){
        return "indexSimple";
    }
}
