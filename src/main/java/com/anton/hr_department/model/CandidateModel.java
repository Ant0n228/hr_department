package com.anton.hr_department.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Entity
@Table(name = "candidate")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class CandidateModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long  idCandidate;

    @Column(name = "fio")
    private String fio;

    @Column(name = "contact_details")
    private String contactDetails;

    @Column(name = "date_of_submission")
    private String dateOfSubmission;

    @Column(name = "application_status")
    private boolean applicationStatus;

    @Column(name = "foreign_language")
    private boolean foreignLanguage;

    @Column(name = "id_vacancy", nullable = false)
    private long idVacancy;

    @Column(name = "id_employee", nullable = false)
    private long idEmployee;

    @Column(name = "id_education", nullable = false)
    private long idEducation;
}