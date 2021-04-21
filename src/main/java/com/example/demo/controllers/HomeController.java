package com.example.demo.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
    @GetMapping("/home")
    @ResponseBody
    public String home() {
        return "home page";
    }

    @PreAuthorize ("hasRole('Admin')")
    @GetMapping("/admin-page")
    @ResponseBody
    public String admin_page() {
        return "admin page in user";
    }
    @PreAuthorize ("hasRole('User')")
    @GetMapping("/user-page")
    @ResponseBody
    public String user_page() {
        return "user page in user";
    }
}
