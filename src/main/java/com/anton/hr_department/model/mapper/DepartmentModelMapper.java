package com.anton.hr_department.model.mapper;

import com.anton.hr_department.dto.DepartmentDTO;
import com.anton.hr_department.model.DepartmentModel;

public class DepartmentModelMapper {
    public static DepartmentModel mapToModel(DepartmentDTO dto) {
        return new DepartmentModel()
                .setIdDepartment(dto.getIdDepartment())
                .setDepartmentName(dto.getDepartmentName())
                .setNumberOfPeople(dto.getNumberOfPeople());
    }
}
