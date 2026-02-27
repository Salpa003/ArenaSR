package com.example.arenasr.controller;

import com.example.arenasr.dto.UserLoginDto;
import com.example.arenasr.entity.User;
import com.example.arenasr.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final UserService userService;

    @GetMapping("/register")
    public String getRegister() {
        return "register";
    }

    @PostMapping("/register")
    public String postRegister(@ModelAttribute("user") UserLoginDto userDto, Model mav) {
       String error = userService.getValidationError(userDto);
        System.out.println(error);
       if (error != null) {
           mav.addAttribute("errorMessage", error);
           return "register";
       }
        User user = userService.createUser(userDto);
       if (user==null) {
           mav.addAttribute("errorMessage", "Не удалось создать пользователя!");
           return "register";
       }
        return "redirect:/success?username="+user.getUsername();
    }

    @GetMapping("/success")
    public String successPage(@RequestParam("username") String username, Model mav) {
        mav.addAttribute("username",username);
        return "success";
    }
}
