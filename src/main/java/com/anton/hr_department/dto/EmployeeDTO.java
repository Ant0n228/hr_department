package com.anton.hr_department.dto;

import com.anton.hr_department.model.DepartmentModel;
import com.anton.hr_department.model.EducationModel;
import com.anton.hr_department.model.VacancyModel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class EmployeeDTO {
    private Long idEmployee;

    private String fio;
    private String email;
    private String foreignLanguage;
    private String position;
    private double salary;
    private LocalDate dateOfEmployment;
    private LocalDate dateOfDismissal;

    private EducationModel education;
    private DepartmentModel department;
    private VacancyModel vacancy;

}
