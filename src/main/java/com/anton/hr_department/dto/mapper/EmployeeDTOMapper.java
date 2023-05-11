package com.anton.hr_department.dto.mapper;

import com.anton.hr_department.dto.EmployeeDTO;
import com.anton.hr_department.model.EmployeeModel;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class EmployeeDTOMapper {

    // mapping EmployeeModel into EmployeeDTO
    public EmployeeDTO mapToDTO(EmployeeModel model) {
        return new EmployeeDTO()
                .setIdEmployee(model.getIdEmployee())
                .setFio(model.getFio())
                .setPosition(model.getPosition())
                .setSalary(model.getSalary())
                .setDateOfDismissal(model.getDateOfDismissal())
                .setEmail(model.getEmail())
                .setDateOfEmployment(model.getDateOfEmployment())
                .setEducation(model.getEducation())
                .setVacancy(model.getVacancy())
                .setForeignLanguage(model.getForeignLanguage());
    }
    // mapping EmployeeDTO into EmployeeModel
    public EmployeeModel mapToModel(EmployeeDTO dto) {
        return new EmployeeModel()
                .setIdEmployee(dto.getIdEmployee())
                .setFio(dto.getFio())
                .setPosition(dto.getPosition())
                .setSalary(dto.getSalary())
                .setDateOfDismissal(dto.getDateOfDismissal())
                .setEmail(dto.getEmail())
                .setDateOfEmployment(dto.getDateOfEmployment())
                .setEducation(dto.getEducation())
                .setDepartment(dto.getDepartment())
                .setVacancy(dto.getVacancy())
                .setForeignLanguage(dto.getForeignLanguage());
    }
}