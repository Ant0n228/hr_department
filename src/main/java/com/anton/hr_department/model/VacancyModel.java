package com.anton.hr_department.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class VacancyModel {
    private long idVacancy;
    private String jobTitle;
    private String dateOfPublication;
    private double salary;
    private int idRequirements;
}
