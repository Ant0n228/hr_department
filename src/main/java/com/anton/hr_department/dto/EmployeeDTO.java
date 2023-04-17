package com.anton.hr_department.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.sql.Date;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class EmployeeDTO {
    private long idEmployee;
    private String fio;
    private String position;
    private double salary;
    private Date dateOfEmployment;
    private String contactDetails;
    private Date dateOfDismissal;
    private long idEducation;
    private long idDepartment;
}
