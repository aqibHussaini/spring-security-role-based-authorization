package com.example.demo.services;

import com.example.demo.Entity.Roles;
import com.example.demo.Entity.User;
import com.example.demo.repositroy.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userService {
    @Autowired
    UserRepository userRepository;
public boolean hasRole(int  u_id,String role)
{
    boolean res=false;
   User user =this.userRepository.findById(u_id).get();
   for(Roles r:user.getRoles())
   {
       if(r.getRole().equals(role))
       {
           res=true;
       }
   }
   return res;
}
}
