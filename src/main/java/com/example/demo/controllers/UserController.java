package com.example.demo.controllers;

import com.example.demo.Entity.Roles;
import com.example.demo.Entity.User;
import com.example.demo.repositroy.RoleRepository;
import com.example.demo.repositroy.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @GetMapping("/register")
    public String userForm(Model model)
    {
        model.addAttribute("users",this.userRepository.findAll());
        model.addAttribute("roles",this.roleRepository.findAll());
      
        return "user.html";
    }

    @PostMapping("/register")
    public String save(User user)
    {
        List<Roles> rolesList=new ArrayList<Roles>();
        rolesList.add(this.roleRepository.findByRole("User"));
        user.setRoles(rolesList);
        this.userRepository.save(user);
        return "redirect:/register";
    }

    @PostMapping("/update-roles")
    public String updateRole(@RequestParam("roles") String roles[],@RequestParam("id")int id)
    {
        List<Roles> list=new ArrayList<>();
        for(String s:roles)
        {
           Roles  roles1= this.roleRepository.findByRole(s);
           list.add(roles1);
        }
       User user= this.userRepository.findById(id).get();
        user.setRoles(list);
        this.userRepository.save(user);
        return "redirect:/register";
    }
}
