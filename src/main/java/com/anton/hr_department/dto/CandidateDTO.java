package com.anton.hr_department.dto;


import com.anton.hr_department.model.EducationModel;
import com.anton.hr_department.model.VacancyModel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class CandidateDTO {
    private Long idCandidate;
    private String fio;
    private String email;
    private LocalDate dateOfSubmission;
    private boolean applicationStatus;
    private String foreignLanguage;
    private VacancyModel vacancy;
    private EducationModel education;
}
