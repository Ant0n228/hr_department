package com.anton.hr_department.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class VacancyDTO {
    private String jobTitle;
    private String dateOfPublication;
    private double salary;
    private int idRequirements;
}
