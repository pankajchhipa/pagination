package com.practice.demo.services;

import com.practice.demo.dao.UserRepository;
import com.practice.demo.entity.UserEntity;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<UserEntity> byUserName = userRepository.findByUserName(username);
        System.out.println(byUserName.get());
        MyUserDetail userKonMilo = byUserName.map(MyUserDetail::new)
                .orElseThrow(() -> new UsernameNotFoundException("User kon milo"));
        return userKonMilo;
    }
}
