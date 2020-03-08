package com.oauthtest.repository;

import com.oauthtest.bean.User;
import com.oauthtest.bean.projection.UsersProjection;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

//@Repository
@RepositoryRestResource(path = "userInfo", excerptProjection = UsersProjection.class)
public interface UserAuthRepository extends PagingAndSortingRepository<User, String>, JpaSpecificationExecutor<User>  {

    User findByUserId(String userId);

}
