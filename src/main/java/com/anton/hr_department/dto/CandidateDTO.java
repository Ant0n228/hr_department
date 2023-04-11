package com.anton.hr_department.dto;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class CandidateDTO {
    private long idCandidate;
    private String fio;
    private String contactDetails;
    private String dateOfSubmission;
    private boolean applicationStatus;
    private boolean foreignLanguage;
    private long idVacancy;
    private long idEmployee;
    private long idEducation;
}
