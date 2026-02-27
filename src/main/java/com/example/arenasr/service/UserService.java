package com.example.arenasr.service;

import com.example.arenasr.dto.UserLoginDto;
import com.example.arenasr.entity.User;
import com.example.arenasr.mapper.UserLoginDtoMapper;
import com.example.arenasr.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserLoginDtoMapper mapper;
    public String getValidationError(UserLoginDto dto) {
        if(userRepository.existsUserByUsername(dto.getUsername())) {
            return"Пользователь с таким логином уже существует!";
        }
        if (dto.getPassword().length() < 8) {
            return "Пароль слишком короткий. Не менее 8 символов";
        }
        return null;
    }

    public User createUser(UserLoginDto dto) {
       String error = getValidationError(dto);
       if (error == null) {
           User user = mapper.map(dto);
           user.setGold(100.0);
           userRepository.save(user);
           return user;
       }
        return null;
    }
}
