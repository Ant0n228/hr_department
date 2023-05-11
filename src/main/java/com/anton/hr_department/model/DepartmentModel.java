package com.anton.hr_department.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@Entity
@Table(name = "department", schema = "hr_department")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class DepartmentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDepartment;

    private String departmentName;
    private int numberOfPeople;

    @OneToMany(mappedBy = "department")
    private List<EmployeeModel> employeeModel;
}
