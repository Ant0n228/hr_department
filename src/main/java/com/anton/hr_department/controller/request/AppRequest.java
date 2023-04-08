package com.anton.hr_department.controller.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class AppRequest {
    private CandidateRequest candidate;
    private DepartmentRequest department;
    private EducationRequest education;
    private EmployeeRequest employee;
    private RequirementsRequest requirements;
    private VacancyRequest vacancy;
}
