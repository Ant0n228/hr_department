package com.anton.hr_department.service;

import com.anton.hr_department.model.EmployeeModel;
import com.anton.hr_department.model.User;
import com.anton.hr_department.model.enums.Role;
import com.anton.hr_department.repository.EmployeeModelRepository;
import com.anton.hr_department.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;


@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final EmployeeModelRepository employeeModelRepository;
    private final PasswordEncoder passwordEncoder;

    public boolean createUser(User user) {
        if (userRepository.findByEmail(user.getEmail()) != null
                || employeeModelRepository.findByEmail(user.getEmail()) == null
                || userRepository.findByLogin(user.getLogin()) != null) {
            return false;
        }

        EmployeeModel employee = employeeModelRepository.findByEmail(user.getEmail());
        user = setUserRole(employee, user);
        user.setEmployee(employee);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        log.info("Saving new user with login {}", user.getLogin());
        userRepository.save(user);
        return true;
    }

    public User getUserByPrincipal(Principal principal) {
        if (principal == null) return new User();
        return userRepository.findByLogin(principal.getName());
    }

    public User setUserRole(EmployeeModel employee, User user) {
        switch (employee.getPosition()) {
            case "Начальник отдела" -> user.setRole(Role.ROLE_CHIEF);
            case "Специалист по кадрам" -> user.setRole(Role.ROLE_HR_SPECIALIST);
            case "Инженер отдела кадров" -> user.setRole(Role.ROLE_DEPARTMENT_ENGINEER);
            default -> user.setRole(Role.ROLE_USER);
        }
        return user;
    }

    public void editUser(Long id, User user) {
        User userToEdit = userRepository.findById(id).orElseThrow();
        userToEdit.setLogin(user.getLogin());
        userToEdit.setPassword(user.getPassword());
        userRepository.save(userRepository.findById(id).orElseThrow());
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    public Boolean doPasswordsMatch(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }

    public String doPasswordEncode(String password) {
        return passwordEncoder.encode(password);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public void updatePrincipal(User user) {
        Authentication authentication = new UsernamePasswordAuthenticationToken(user, user.getPassword(), user.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}
