package com.anton.hr_department.controller.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class EducationRequest {
    private String educationalInstitution;
    private String faculty;
    private String specialization;
    private String dateOfAdmission;
    private String dateOfGraduation;
}
