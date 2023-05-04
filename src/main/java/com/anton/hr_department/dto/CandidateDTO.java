package com.anton.hr_department.dto;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.sql.Date;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class CandidateDTO {
    private Long idCandidate;
    private String fio;
    private String email;
    private Date dateOfSubmission;
    private boolean applicationStatus = false;
    private String foreignLanguage;
    private Long idVacancy;
    private Long idEducation;
}
