package com.oauthtest.bean;

import lombok.*;

import javax.persistence.*;

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
    //private String role;

    @ManyToOne(targetEntity=RoleMngt.class, fetch=FetchType.EAGER)
    @JoinColumn(name="ROLE")
    private RoleMngt roleMngt;
}
