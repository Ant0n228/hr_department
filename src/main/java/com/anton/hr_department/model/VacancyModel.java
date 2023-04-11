package com.anton.hr_department.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Entity
@Table(name = "vacancy")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class VacancyModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idVacancy;

    @Column(name = "job_title")
    private String jobTitle;

    @Column(name = "date_of_publication")
    private String dateOfPublication;

    @Column(name = "salary")
    private double salary;

    @Column(name = "id_requirements")
    private long idRequirements;
}
