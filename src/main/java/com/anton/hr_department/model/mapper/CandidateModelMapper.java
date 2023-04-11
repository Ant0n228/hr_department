package com.anton.hr_department.model.mapper;

import com.anton.hr_department.dto.CandidateDTO;
import com.anton.hr_department.model.CandidateModel;

public class CandidateModelMapper{
    public static CandidateModel mapToModel(CandidateDTO dto) {
        return new CandidateModel()
                .setIdCandidate(dto.getIdCandidate())
                .setFio(dto.getFio())
                .setContactDetails(dto.getContactDetails())
                .setDateOfSubmission(dto.getDateOfSubmission())
                .setApplicationStatus(dto.isApplicationStatus())
                .setForeignLanguage(dto.isForeignLanguage())
                .setIdVacancy(dto.getIdVacancy())
                .setIdEmployee(dto.getIdEmployee())
                .setIdEducation(dto.getIdEducation());
    }
}
