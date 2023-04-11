package com.anton.hr_department.model.mapper;

import com.anton.hr_department.dto.VacancyDTO;
import com.anton.hr_department.model.VacancyModel;

public class VacancyModelMapper {

    public static VacancyModel mapToModel(VacancyDTO dto) {
        return new VacancyModel()
                .setIdVacancy(dto.getIdVacancy())
                .setJobTitle(dto.getJobTitle())
                .setDateOfPublication(dto.getDateOfPublication())
                .setSalary(dto.getSalary())
                .setIdRequirements(dto.getIdRequirements());
    }
}
