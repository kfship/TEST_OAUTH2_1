package com.oauthtest.bean;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class User {

    @Id
    private String userId;
    private String password;
    private String name;
    private String role;
    private String extraValue;
}
