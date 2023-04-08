package com.anton.hr_department.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class CandidateDTO {
    private String fio;
    private String contactDetails;
    private String dateOfSubmission;
    private boolean applicationStatus;
    private boolean foreignLanguage;
    private int idVacancy;
    private int idEmployee;
    private int idEducation;
}
