package com.anton.hr_department.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.sql.Date;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class EducationDTO {
    private Long idEducation;
    private String educationalInstitution;
    private String faculty;
    private String specialization;
    private Date dateOfAdmission;
    private Date dateOfGraduation;
}
