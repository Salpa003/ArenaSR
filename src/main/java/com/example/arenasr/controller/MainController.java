package com.example.arenasr.controller;

import com.example.arenasr.dto.UserLoginDto;
import com.example.arenasr.dto.UserReadDto;
import com.example.arenasr.dto.UserRegisterDto;
import com.example.arenasr.entity.User;
import com.example.arenasr.exception.UserException;
import com.example.arenasr.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final UserService userService;

    @GetMapping("/register")
    public String getRegister() {
        return "register";
    }

    @PostMapping("/register")
    public String postRegister(@ModelAttribute("user") UserRegisterDto userDto, Model model) {
        UserReadDto user;
        try {
            user = userService.createUser(userDto);
        } catch (UserException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "register";
        }
        if (user == null) {
            model.addAttribute("errorMessage", "Не удалось создать пользователя!");
            return "register";
        }
        return "redirect:/success?username=" + user.getUsername();
    }

    @GetMapping("/success")
    public String successPage(@RequestParam("username") String username, Model model) {
        model.addAttribute("username", username);
        return "success";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String postLogin(@ModelAttribute("user") UserLoginDto dto, Model model) {
        UserReadDto user;
        try {
            user = userService.login(dto);
        } catch (UserException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "login";
        }
        return "redirect:/profile?username=" + user.getUsername();
    }

    @GetMapping("/profile")
    public String profilePage(@RequestParam("username") String username, Model model) {
        Optional<UserReadDto> maybeUser = userService.findUserByUsername(username);
        if (maybeUser.isEmpty())
            return "redirect:/login";
        model.addAttribute("user", maybeUser.get());
        return "profile";
    }
}
