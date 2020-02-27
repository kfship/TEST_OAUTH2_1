package com.oauthtest.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@EnableResourceServer  // API 서버 인증(또는 권한 설정)
@Configuration
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    /*
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/Users").access("#oauth2.hasScope('read')");
    }
    */
}