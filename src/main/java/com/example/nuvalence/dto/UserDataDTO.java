package com.example.nuvalence.dto;

import com.example.nuvalence.enums.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class UserDataDTO {
    private String username;
    private String email;
    private String password;
    List<Role> roles;
}
