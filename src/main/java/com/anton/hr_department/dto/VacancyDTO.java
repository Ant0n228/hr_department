package com.anton.hr_department.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class VacancyDTO {
    private long idVacancy;
    private String jobTitle;
    private String dateOfPublication;
    private double salary;
    private long idRequirements;
}
