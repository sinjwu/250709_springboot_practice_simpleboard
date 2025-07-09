package com.practice.__springboot_practice_simpleboard.controller;

import com.practice.__springboot_practice_simpleboard.dto.LoginDto;
import com.practice.__springboot_practice_simpleboard.model.User;
import com.practice.__springboot_practice_simpleboard.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.beans.BeanInfo;

@Controller
@RequiredArgsConstructor
public class LoginController {
    private final UserRepository userRepository;
    @GetMapping({"/", "/login"})
    public String loginForm(Model model) {
        model.addAttribute("loginDto", new LoginDto());
        return "login";
    }
    @PostMapping("/login")
    public String login(
            @Valid @ModelAttribute LoginDto loginDto,
            BindingResult bindingResult,
            HttpSession httpSession,
            Model model
    ) {
        if (bindingResult.hasErrors()) return "login";
        User user = userRepository.findByUsername(loginDto.getUsername()).orElse(null);
        if (user == null || !user.getPassword().equals(loginDto.getPassword())) {
            model.addAttribute("error", "ID/비밀번호가 올바르지 않습니다");
            return "login";
        }
        httpSession.setAttribute("user", user);
        return "redirect:/posts";
    }
}
