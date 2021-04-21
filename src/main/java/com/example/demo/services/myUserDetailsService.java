package com.example.demo.services;

import com.example.demo.Entity.User;
import com.example.demo.repositroy.UserRepository;
import com.example.demo.util.myUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class myUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
       User user= this.userRepository.findByName(s);
        myUserDetails myUserDetails=new myUserDetails(user);
        return myUserDetails;
    }
}
