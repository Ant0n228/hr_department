package com.anton.hr_department.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.sql.Date;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class VacancyWithRequirementsDTO {
    private Long idVacancyWithRequirements;
    private String jobTitle;
    private double salary;
    private Date dateOfPublication;
    private int numberOfVacancy;
    private String requirements;
    private String jobDescription;

}
