package com.oauthtest.service;

import com.oauthtest.bean.CustomUserDetails;
import com.oauthtest.bean.Users;
import com.oauthtest.repository.UserAuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService  {

    @Autowired
    private UserAuthRepository userAuthRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users user = userAuthRepository.findByUserId(username);

        if(user == null) {

            throw new UsernameNotFoundException(username);

        } else {

            CustomUserDetails customUserDetails = new CustomUserDetails();
            customUserDetails.setUsername(user.getUserId());
            customUserDetails.setPassword(user.getPassword());
            customUserDetails.setNAME(user.getName());
            customUserDetails.setAuthority(user.getRole());
            customUserDetails.setEnabled(true);

            return customUserDetails;
        }
    }
}
