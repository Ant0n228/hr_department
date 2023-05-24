package com.anton.hr_department.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDate;

@Entity
@Table(name = "candidate", schema = "hr_department")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class CandidateModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCandidate;

    @Column(nullable = false)
    private String fio;
    @Column(nullable = false)
    private String email;
    private String foreignLanguage;
    private LocalDate dateOfSubmission;
    private boolean applicationStatus;

    @ManyToOne()
    @JoinColumn(name = "id_vacancy", nullable = false)
    private VacancyModel vacancy;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_education")
    private EducationModel education;

    @PrePersist
    public void init() {
        dateOfSubmission = LocalDate.now();
        applicationStatus = false;
    }
}