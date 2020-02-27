package com.oauthtest.repository;

import com.oauthtest.bean.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAuthRepository extends JpaRepository<Users, String> {

    Users findByUserId(String userId);

}
