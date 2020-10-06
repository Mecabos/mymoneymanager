package com.bij.mymoneymanager.dto.user;

import com.bij.mymoneymanager.model.Role;
import lombok.Data;

import javax.persistence.Id;
import java.util.Set;

public @Data class UserDto {

    @Id
    private int id;
    private String username;
    private String password;
    private Set<Role> roleSet;
}
