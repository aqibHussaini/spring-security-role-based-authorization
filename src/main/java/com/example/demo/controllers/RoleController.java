package com.example.demo.controllers;

import com.example.demo.Entity.Roles;
import com.example.demo.repositroy.RoleRepository;
import com.example.demo.services.roleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class RoleController {
  @Autowired
    roleService roleService;
    @GetMapping("/role-form")
    public  String  add(Model model){
        model.addAttribute("roles",this.roleService.getAll());
        return "role.html";
    }
    @PostMapping("/save-role")
    public  String  save(Roles roles,Model model){
        this.roleService.Save(roles);
        model.addAttribute("roles",this.roleService.getAll());
        return "role.html";
    }
}
