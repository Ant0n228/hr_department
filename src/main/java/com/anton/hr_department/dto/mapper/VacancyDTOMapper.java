package com.anton.hr_department.dto.mapper;

import com.anton.hr_department.dto.VacancyDTO;
import com.anton.hr_department.model.VacancyModel;

public class VacancyDTOMapper {
    public static VacancyDTO mapToDTO(VacancyModel model) {
        return new VacancyDTO()
                .setIdVacancy(model.getIdVacancy())
                .setJobTitle(model.getJobTitle())
                .setDateOfPublication(model.getDateOfPublication())
                .setSalary(model.getSalary())
                .setIdRequirements(model.getIdRequirements())
                .setNumberOfVacancy(model.getNumberOfVacancy());
    }
}
