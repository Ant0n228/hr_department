package com.anton.hr_department.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class DepartmentDTO {
    private Long idDepartment;
    private String departmentName;
    private int numberOfPeople;
}
