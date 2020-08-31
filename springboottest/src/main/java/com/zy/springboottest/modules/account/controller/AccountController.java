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

    @GetMapping("/users")
    public String usersPage() {
        return "index";
    }

    @GetMapping("/roles")
    public String rolesPage() {
        return "index";
    }

    @GetMapping("/resources")
    public String resourcesPage() {
        return "index";
    }

    @GetMapping("/profile")
    public String profilePage() {
        return "index";
    }

}
