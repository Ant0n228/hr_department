package com.anton.hr_department.controller.api;

import com.anton.hr_department.model.User;
import com.anton.hr_department.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class AppController {
    private final UserService userService;
    private User user;

    @GetMapping("/")
    public String main_page(Principal principal, Model model) {
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        return "main-page";
    }

    @GetMapping("/navbar")
    public String navbar(Principal principal, Model model) {
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        return "blocks/navbar";
    }


    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
