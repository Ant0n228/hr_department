package com.anton.hr_department.model.mapper;

import com.anton.hr_department.dto.VacancyWithRequirementsDTO;
import com.anton.hr_department.model.RequirementsModel;
import com.anton.hr_department.model.VacancyModel;

import java.sql.Date;
import java.time.LocalDate;

public class VacancyWithRequirementsModelMapper {
    public static VacancyModel mapToVacancyModel(long idRequirements, VacancyWithRequirementsDTO vacancyWithRequirementsDTO) {
        return new VacancyModel()
                .setIdVacancy(vacancyWithRequirementsDTO.getIdVacancyWithRequirements())
                .setJobTitle(vacancyWithRequirementsDTO.getJobTitle())
                .setDateOfPublication(Date.valueOf(LocalDate.now()))
                .setSalary(vacancyWithRequirementsDTO.getSalary())
                .setNumberOfVacancy(vacancyWithRequirementsDTO.getNumberOfVacancy())
                .setIdRequirements(idRequirements);
    }

    public static RequirementsModel mapToRequirementModel(VacancyWithRequirementsDTO vacancyWithRequirementsDTO) {
        return new RequirementsModel()
                .setIdRequirements(null)
                .setRequirements(vacancyWithRequirementsDTO.getRequirements())
                .setJobDescription(vacancyWithRequirementsDTO.getJobDescription());
    }
}
