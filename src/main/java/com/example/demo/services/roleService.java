package com.example.demo.services;

import com.example.demo.Entity.Roles;
import com.example.demo.repositroy.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class roleService {
    @Autowired
    RoleRepository roleRepository;
    public Roles Save(Roles role)
    {
        return this.roleRepository.save(role);
    }
    public List<Roles> getAll()
    {
        return this.roleRepository.findAll();
    }
}
