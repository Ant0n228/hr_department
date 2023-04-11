package com.anton.hr_department.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class EmployeeDTO {
    private long idEmployee;
    private String fio;
    private String position;
    private double salary;
    private String dateOfEmployment;
    private String contactDetails;
    private String dateOfDismissal;
    private long idEducation;
    private long idDepartment;
}
