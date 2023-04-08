package com.anton.hr_department.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "department")
public class DepartmentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idDepartment;

    @Column(name = "department_name")
    private String departmentName;

    @Column(name = "number_of_people")
    private int numberOfPeople;
}
