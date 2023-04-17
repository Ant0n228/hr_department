package com.anton.hr_department.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.sql.Date;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class EmployeeDTO {
    private Long idEmployee;
    private String fio;
    private String position;
    private double salary;
    private Date dateOfEmployment;
    private String email;
    private Date dateOfDismissal;
    private Long idEducation;
    private Long idDepartment;
}
