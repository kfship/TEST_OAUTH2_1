package com.oauthtest.controller;

import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@RepositoryRestController
@RequestMapping("/api")
public class HelloController {

    @RequestMapping("/hello")
    public @ResponseBody
    String hello() {

        return "hello java";
    }
}
