package com.example.arenasr.service;

import com.example.arenasr.dto.UserLoginDto;
import com.example.arenasr.dto.UserReadDto;
import com.example.arenasr.dto.UserRegisterDto;
import com.example.arenasr.entity.User;
import com.example.arenasr.exception.UserException;
import com.example.arenasr.mapper.UserReadDtoMapper;
import com.example.arenasr.mapper.UserRegisterDtoMapper;
import com.example.arenasr.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserRegisterDtoMapper registerDtoMapper;
    private final UserReadDtoMapper readDtoMapper;

    public UserReadDto createUser(UserRegisterDto dto) throws UserException {
        if (userRepository.existsUserByUsername(dto.getUsername())) {
            throw new UserException("Пользователь с таким логином уже существует!");
        }
        if (dto.getPassword().length() < 8) {
            throw new UserException("Пароль слишком короткий. Не менее 8 символов!");
        }
        User user = registerDtoMapper.map(dto);
        user.setGold(100.0);
        userRepository.save(user);
        return readDtoMapper.unmap(user);
    }

    public UserReadDto login(UserLoginDto dto) throws UserException {
        Optional<User> maybeUser = userRepository.findUserByUsername(dto.getUsername());
        if (maybeUser.isEmpty()) {
            throw new UserException("Пользователь не существует!");
        }
        User user = maybeUser.get();
        if (user.getPassword().equals(dto.getPassword())) {
            return readDtoMapper.unmap(user);
        } else {
            throw new UserException("Неверный пароль!");
        }
    }

    public Optional<UserReadDto> findUserByUsername(String username) {
     Optional<User> maybeUser = userRepository.findUserByUsername(username);
        return maybeUser.map(readDtoMapper::unmap);
    }

}
