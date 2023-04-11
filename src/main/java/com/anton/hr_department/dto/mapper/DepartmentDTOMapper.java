package com.anton.hr_department.dto.mapper;

import com.anton.hr_department.dto.DepartmentDTO;
import com.anton.hr_department.model.DepartmentModel;

public class DepartmentDTOMapper {

    public static DepartmentDTO mapToDTO(DepartmentModel model) {
        return new DepartmentDTO()
                .setIdDepartment(model.getIdDepartment())
                .setDepartmentName(model.getDepartmentName())
                .setNumberOfPeople(model.getNumberOfPeople());
    }
}