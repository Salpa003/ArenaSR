package com.example.arenasr.mapper;

import com.example.arenasr.dto.UserRegisterDto;
import com.example.arenasr.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserRegisterDtoMapper implements Mapper<UserRegisterDto, User> {
    @Override
    public User map(UserRegisterDto dto) {
        return  User.builder()
                .username(dto.getUsername())
                .password(dto.getPassword())
                .build();
    }

    @Override
    public UserRegisterDto unmap(User user) {
        return null;
    }
}
