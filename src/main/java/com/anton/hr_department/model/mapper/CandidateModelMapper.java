package com.anton.hr_department.model.mapper;

import com.anton.hr_department.dto.CandidateDTO;
import com.anton.hr_department.model.CandidateModel;

import java.sql.Date;
import java.time.LocalDate;

public class CandidateModelMapper{
    public static CandidateModel mapToModel(CandidateDTO dto) {
        return new CandidateModel()
                .setIdCandidate(dto.getIdCandidate())
                .setFio(dto.getFio())
                .setEmail(dto.getEmail())
                .setDateOfSubmission(Date.valueOf(LocalDate.now()))
                .setApplicationStatus(false)
                .setForeignLanguage(dto.getForeignLanguage())
                .setIdVacancy(dto.getIdVacancy())
                .setIdEmployee(dto.getIdEmployee())
                .setIdEducation(dto.getIdEducation());
    }
}
