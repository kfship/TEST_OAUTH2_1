package com.oauthtest.bean.projection;

import com.oauthtest.bean.User;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "userExcerpt", types = User.class)
public interface UsersExcerpt {
    public String getName();

}
