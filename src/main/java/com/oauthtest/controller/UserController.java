package com.oauthtest.controller;

import com.oauthtest.bean.Users;
import com.oauthtest.repository.UserAuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserAuthRepository userAuthRepository;

    @RequestMapping("/Users")
    public Users testEx() {

        Users users = userAuthRepository.findByUserId("kfship");

        return users;
    }

    @RequestMapping("/hello")
    public String hello() {

        return "hello";
    }
}
