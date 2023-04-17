package com.anton.hr_department.dto.mapper;

import com.anton.hr_department.dto.VacancyWithRequirementsDTO;
import com.anton.hr_department.model.RequirementsModel;
import com.anton.hr_department.model.VacancyModel;

public class VacancyWithRequirementsDTOMapper {

    public static VacancyWithRequirementsDTO mapToDTO(VacancyModel vacancyModel,
                                                      RequirementsModel requirementsModel) {
        return new VacancyWithRequirementsDTO()
                .setIdVacancyWithRequirements(vacancyModel.getIdVacancy())
                .setJobTitle(vacancyModel.getJobTitle())
                .setSalary(vacancyModel.getSalary())
                .setDateOfPublication(vacancyModel.getDateOfPublication())
                .setNumberOfVacancy(vacancyModel.getNumberOfVacancy())
                .setRequirements(requirementsModel.getRequirements())
                .setJobDescription(requirementsModel.getJobDescription());
    }
}
