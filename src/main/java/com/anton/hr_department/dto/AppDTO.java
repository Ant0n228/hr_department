package com.anton.hr_department.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class AppDTO {
    private CandidateDTO candidate;
    private DepartmentDTO department;
    private EducationDTO education;
    private EmployeeDTO employee;
    private VacancyDTO vacancy;
}
