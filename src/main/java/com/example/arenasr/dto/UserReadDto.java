package com.example.arenasr.dto;

import lombok.Value;

@Value
public class UserReadDto {
    String username;
    String password;
    Double gold;
    Integer wins;
    Integer losses;
}
