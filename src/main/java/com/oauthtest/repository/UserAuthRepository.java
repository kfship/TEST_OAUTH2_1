package com.oauthtest.repository;

import com.oauthtest.bean.User;
import com.oauthtest.bean.projection.UsersExcerpt;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(excerptProjection = UsersExcerpt.class)
public interface UserAuthRepository extends SearchableRepository<User, String> {

    User findByUserId(String userId);
}
