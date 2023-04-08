package com.anton.hr_department.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class AppModel {
    private CandidateModel candidate;
    private DepartmentModel department;
    private EducationModel education;
    private EmployeeModel employee;
    private RequirementsModel requirements;
    private VacancyModel vacancy;
}
