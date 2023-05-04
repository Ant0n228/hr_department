package com.anton.hr_department.dto.mapper;

import com.anton.hr_department.dto.EmployeeDTO;
import com.anton.hr_department.model.EmployeeModel;

public class EmployeeDTOMapper {

    public static EmployeeDTO mapToDTO(EmployeeModel model) {
        return new EmployeeDTO()
                .setIdEmployee(model.getIdEmployee())
                .setFio(model.getFio())
                .setPosition(model.getPosition())
                .setSalary(model.getSalary())
                .setDateOfDismissal(model.getDateOfDismissal())
                .setEmail(model.getEmail())
                .setDateOfEmployment(model.getDateOfEmployment())
                .setIdEducation(model.getIdEducation())
                .setIdVacancy(model.getIdVacancy())
                .setForeignLanguage(model.getForeignLanguage())
                .setIdDepartment(model.getIdDepartment());
    }
}