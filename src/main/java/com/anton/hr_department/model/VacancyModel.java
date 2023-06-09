package com.anton.hr_department.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "vacancy", schema = "hr_department")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class VacancyModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVacancy;

    @Column(nullable = false)
    private String jobTitle;
    private LocalDate dateOfPublication;
    private double salary;
    private int numberOfVacancy;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_requirements")
    private RequirementsModel requirements;

    @OneToMany(mappedBy = "vacancy")
    private List<EmployeeModel> employees;

    @OneToMany(mappedBy = "vacancy")
    private List<CandidateModel> candidates;

    @PrePersist
    public void init() {
        dateOfPublication = LocalDate.now();
    }
}
