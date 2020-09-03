package com.zy.springboottest.modules.account.controller;

import com.zy.springboottest.modules.account.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private UserService userService;

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

    @GetMapping("/registerVue")
    public String registerVuePage() {
        return "indexSimple";
    }

    @GetMapping("/logout")
    public String logout(ModelMap modelMap) {
        userService.logout();
        modelMap.addAttribute("template", "account/login");
        return "indexSimple";
    }
}
