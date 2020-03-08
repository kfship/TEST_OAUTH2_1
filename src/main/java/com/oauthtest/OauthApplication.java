package com.oauthtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.oauthtest.bean")
@EnableJpaRepositories(basePackages = "com.oauthtest.repository")
public class OauthApplication {

    public static void main(String[] args) {


        //BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        //System.out.println("-=================================================================");
        //System.out.println(encoder.encode("1234"));

        SpringApplication.run(OauthApplication.class, args);
    }
}