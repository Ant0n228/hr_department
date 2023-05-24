package com.anton.hr_department.model;


import com.anton.hr_department.model.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;


@Entity
@Table(name = "users", schema = "hr_department")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_user;
    private String login;
    private String email;
    private String password;
    private Role role;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_employee")
    private EmployeeModel employee;

    public boolean isChief() { return role.equals(Role.ROLE_CHIEF);}
    public boolean isHrSpecialist() {return role.equals(Role.ROLE_HR_SPECIALIST);}
    public boolean isDepartmentEngineer() {return role.equals(Role.ROLE_DEPARTMENT_ENGINEER);}
    public boolean isUser() {return role.equals(Role.ROLE_USER);}
    public EmployeeModel getEmployee(){
        return employee;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(role);
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
