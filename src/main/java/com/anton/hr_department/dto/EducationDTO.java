package com.anton.hr_department.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class EducationDTO {
    private String educationalInstitution;
    private String faculty;
    private String specialization;
    private String dateOfAdmission;
    private String dateOfGraduation;
}
