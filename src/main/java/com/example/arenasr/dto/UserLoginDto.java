package com.example.arenasr.dto;

import lombok.Data;
import lombok.Value;

@Value
public class UserLoginDto {
    private String username;
    private String password;
}
