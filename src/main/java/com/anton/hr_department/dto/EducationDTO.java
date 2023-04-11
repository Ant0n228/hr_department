package com.anton.hr_department.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class EducationDTO {
    private long idEducation;
    private String educationalInstitution;
    private String faculty;
    private String specialization;
    private String dateOfAdmission;
    private String dateOfGraduation;
}
