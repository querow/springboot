package com.zy.springboottest.modules.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/common")
public class CommonController {

    @GetMapping("/dashboard")
    public String dashboardPage() {
        return "index";
    }

    @GetMapping("/dashboard2")
    public String dashboard2Page() {
        return "index";
    }

    @GetMapping("/403")
    public String errorPageFor403() {
        return "index";
    }
}
