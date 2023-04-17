package com.anton.hr_department.model.mapper;

import com.anton.hr_department.dto.VacancyWithRequirementsDTO;
import com.anton.hr_department.model.RequirementsModel;
import com.anton.hr_department.model.VacancyModel;

import java.sql.Date;
import java.time.LocalDate;

public class VacancyWithRequirementsModelMapper {
    //TODO idRequirements won't be a null
    public static VacancyModel mapToVacancyModel(VacancyWithRequirementsDTO vacancyWithRequirementsDTO) {
        RequirementsModel requirementsModel = mapToRequirementModel(vacancyWithRequirementsDTO);
        Long idRequirement = requirementsModel.getIdRequirements();
        return new VacancyModel()
                .setIdVacancy(vacancyWithRequirementsDTO.getIdVacancyWithRequirements())
                .setJobTitle(vacancyWithRequirementsDTO.getJobTitle())
                .setDateOfPublication(Date.valueOf(LocalDate.now()))
                .setSalary(vacancyWithRequirementsDTO.getSalary())
                .setNumberOfVacancy(vacancyWithRequirementsDTO.getNumberOfVacancy())
                // TODO How does it work?
                .setIdRequirements(idRequirement != null ? idRequirement : 1l);
    }

    public static RequirementsModel mapToRequirementModel(VacancyWithRequirementsDTO vacancyWithRequirementsDTO) {
        return new RequirementsModel()
                .setIdRequirements(null)
                .setRequirements(vacancyWithRequirementsDTO.getRequirements())
                .setJobDescription(vacancyWithRequirementsDTO.getJobDescription());
    }
}
