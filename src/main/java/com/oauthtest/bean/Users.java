package com.oauthtest.bean;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Users {

    @Id
    private String userId;
    private String password;
    private String name;
    private String role;
}
