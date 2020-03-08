package com.oauthtest.bean.projection;

import com.oauthtest.bean.RoleMngt;
import com.oauthtest.bean.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "usersProjection", types = User.class)
public interface UsersProjection {

    @Value("#{target.name}")
    String getName();

    @Value("#{target.RoleMngt.roleName}")
    String getRoleName();
}
