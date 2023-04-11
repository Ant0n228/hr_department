package com.anton.hr_department.dto.mapper;

import com.anton.hr_department.dto.CandidateDTO;
import com.anton.hr_department.model.CandidateModel;

public class CandidateDTOMapper {
    public static CandidateDTO mapToDTO(CandidateModel model) {
        return new CandidateDTO()
                .setIdCandidate(model.getIdCandidate())
                .setFio(model.getFio())
                .setEmail(model.getEmail())
                .setDateOfSubmission(model.getDateOfSubmission())
                .setApplicationStatus(model.isApplicationStatus())
                .setForeignLanguage(model.isForeignLanguage())
                .setIdVacancy(model.getIdVacancy())
                .setIdEmployee(model.getIdEmployee())
                .setIdEducation(model.getIdEducation());
    }
}
