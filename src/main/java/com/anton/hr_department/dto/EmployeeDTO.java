package com.anton.hr_department.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class EmployeeDTO {
    private String fio;
    private String position;
    private double salary;
    private String dateOfEmployment;
    private String contactDetails;
    private String dateOfDismissal;
    private int idEducation;
    private int idDepartment;
}
