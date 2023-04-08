package com.anton.hr_department.controller.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class VacancyRequest {
    private String jobTitle;
    private String dateOfPublication;
    private double salary;
    private int idRequirements;
}
