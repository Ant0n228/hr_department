package com.anton.hr_department.model.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ROLE_CHIEF, ROLE_HR_SPECIALIST, ROLE_DEPARTMENT_ENGINEER, ROLE_USER;

    @Override
    public String getAuthority() {
        return name();
    }

}

