package com.anton.hr_department.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.sql.Date;

@Entity
@Table(name = "vacancy")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class VacancyModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVacancy;
    private String jobTitle;
    private Date dateOfPublication;
    private double salary;
    @Column(nullable = false)
    private Long idRequirements;
    private int numberOfVacancy;
}
