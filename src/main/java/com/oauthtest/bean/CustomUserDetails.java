package com.oauthtest.bean;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class CustomUserDetails implements UserDetails {

    private String ID;
    private String PASSWORD;
    private String AUTHORITY;
    private boolean ENABLED;
    private String NAME;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        ArrayList<GrantedAuthority> auth = new ArrayList<GrantedAuthority>();
        auth.add(new SimpleGrantedAuthority(AUTHORITY));
        return auth;
    }

    @Override
    public String getPassword() {
        return PASSWORD;
    }

    @Override
    public String getUsername() {
        return ID;
    }

    public void setAuthority(String authority) {
        AUTHORITY = authority;
    }

    public String getNAME() {
        return NAME;
    }

    @Override
    public boolean isEnabled() {
        return ENABLED;
    }

    public void setPassword(String password) { PASSWORD = password; }

    public void setUsername(String username) { ID = username; }

    public void setNAME(String name) {
        NAME = name;
    }

    public void setEnabled(boolean enabled) { ENABLED = enabled; }



    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }






}
