package com.oauthtest.controller;

import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


/*

@RepositoryRestController를 사용한 경우 클래스 단위의 RequestMapping이 없는 경우 접근이 불가하였음
@RestController를 사용한 경우에는 상관 없이 접근 가능함


*/

@RestController
//@RepositoryRestController
@RequestMapping("/api")
public class HelloController {

    @RequestMapping("/hello")
    public @ResponseBody
    String hello() {

        return "hello java";
    }
}
