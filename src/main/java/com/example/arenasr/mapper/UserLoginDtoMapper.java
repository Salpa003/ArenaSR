package com.example.arenasr.mapper;

import com.example.arenasr.dto.UserLoginDto;
import com.example.arenasr.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserLoginDtoMapper implements Mapper<UserLoginDto, User> {
    @Override
    public User map(UserLoginDto dto) {
        return  User.builder()
                .username(dto.getUsername())
                .password(dto.getPassword())
                .build();
    }

    @Override
    public UserLoginDto unmap(User user) {
        return null;
    }
}
