package com.hostels.dto;

import com.hostels.enums.Role;
import com.hostels.model.User;
import lombok.Data;

@Data
public class UserCreateDto {
    private String name;
    private String email;
    private String password;
    private Role role;

    public User toEntity() {
        return new User(name, email, password, role);
    }
}
