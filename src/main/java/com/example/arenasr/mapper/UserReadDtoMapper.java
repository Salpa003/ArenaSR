package com.example.arenasr.mapper;

import com.example.arenasr.dto.UserReadDto;
import com.example.arenasr.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserReadDtoMapper implements Mapper<UserReadDto, User> {
    @Override
    public User map(UserReadDto dto) {
        return User.builder()
                .username(dto.getUsername())
                .password(dto.getPassword())
                .gold(dto.getGold())
                .build();
    }

    @Override
    public UserReadDto unmap(User user) {
        return new UserReadDto(user.getUsername(), user.getPassword(), user.getGold(), user.getWins(), user.getLosses());
    }
}
