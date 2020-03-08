package com.oauthtest.bean;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class RoleMngt {

    @Id
    String role;
    String roleName;

}
