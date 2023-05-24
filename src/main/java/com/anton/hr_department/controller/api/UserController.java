package com.anton.hr_department.controller.api;

import com.anton.hr_department.model.User;
import com.anton.hr_department.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String createUser(User user, Model model){
        if(!userService.createUser(user)) {
            model.addAttribute("errorMessage","Ошибка регистрации пользователя с логином: " + user.getLogin());
            return "registration";
        }
        return "redirect:/login";
    }

    @GetMapping("/user/edit/{id}")
    public String editUser(@PathVariable Long id, Principal principal, Model model){
        User userToEdit = userService.getUserById(id);
        model.addAttribute("user", userToEdit);
        return "user-edit";
    }
    @PostMapping("/user/editing/{id}")
    public String editingUser(@PathVariable Long id, @RequestParam(name="oldPassword") String oldPassword,
                              @RequestParam(name="password") String password,@RequestParam(name="login") String login, Model model)
    {
        User user = userService.getUserById(id);
        if(!(password.isEmpty() || oldPassword.isEmpty())) {
            if (userService.doPasswordsMatch(oldPassword, user.getPassword())) {
                user.setPassword(userService.doPasswordEncode(password));
            } else {
                return "redirect:/user/edit/{id}";
            }
        }
        user.setLogin(login);
        userService.editUser(id, user);
        userService.updatePrincipal(userService.getUserById(id));
        model.addAttribute("user", userService.getUserById(id));
        return "main-page";
    }


    @PostMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable Long id, @RequestParam(name = "password", required = false)String password,
                             @RequestParam(name = "directorId", required = false)Long directorId,
                             @RequestParam(name = "employeeId", required = false)Long employeeId){
        if(directorId!=null){
            userService.deleteUser(id);
            return "redirect:/employees";
        }
        if(userService.doPasswordsMatch(password, userService.getUserById(id).getPassword())){
            userService.deleteUser(id);
            return "registration";
        } else return "redirect:/user/edit/{id}";
    }
}