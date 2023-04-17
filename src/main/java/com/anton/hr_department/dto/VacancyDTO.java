package com.anton.hr_department.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.sql.Date;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class VacancyDTO {
    private Long idVacancy;
    private String jobTitle;
    private Date dateOfPublication;
    private double salary;
    private Long idRequirements;
    private int numberOfVacancy;
}
