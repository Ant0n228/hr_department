package com.anton.hr_department.model.mapper;

import com.anton.hr_department.dto.VacancyDTO;
import com.anton.hr_department.model.VacancyModel;

import java.sql.Date;
import java.time.LocalDate;

public class VacancyModelMapper {

    public static VacancyModel mapToModel(VacancyDTO dto) {
        return new VacancyModel()
                .setIdVacancy(dto.getIdVacancy())
                .setJobTitle(dto.getJobTitle())
                .setDateOfPublication(Date.valueOf(LocalDate.now()))
                .setSalary(dto.getSalary())
                .setIdRequirements(dto.getIdRequirements())
                .setNumberOfVacancy(dto.getNumberOfVacancy());
    }
}
