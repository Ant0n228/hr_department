package com.anton.hr_department.configurations;

import com.anton.hr_department.controller.api.AppController;
import com.anton.hr_department.model.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
@Slf4j
public class LoginSuccessListener implements ApplicationListener<AuthenticationSuccessEvent> {
    private final AppController appController;
    @Override
    public void onApplicationEvent(AuthenticationSuccessEvent evt) {
        appController.setUser((User)evt.getAuthentication().getPrincipal());
        log.info("{} has just logged in ", appController.getUser().getUsername());

    }
}