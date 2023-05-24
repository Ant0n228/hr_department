package com.anton.hr_department.dto.mapper;

import com.anton.hr_department.dto.CandidateDTO;
import com.anton.hr_department.model.CandidateModel;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@NoArgsConstructor
public class CandidateDTOMapper {
    // mapping CandidateModel into CandidateDTO
    public CandidateDTO mapToDTO(CandidateModel model) {
        return new CandidateDTO()
                .setIdCandidate(model.getIdCandidate())
                .setFio(model.getFio())
                .setEmail(model.getEmail())
                .setDateOfSubmission(model.getDateOfSubmission())
                .setApplicationStatus(model.isApplicationStatus())
                .setForeignLanguage(model.getForeignLanguage())
                .setVacancy(model.getVacancy())
                .setEducation(model.getEducation());
    }
    // mapping CandidateDTO into CandidateModel
    public CandidateModel mapToModel(CandidateDTO dto) {
        return new CandidateModel()
                .setIdCandidate(dto.getIdCandidate())
                .setFio(dto.getFio())
                .setEmail(dto.getEmail())
                .setDateOfSubmission(dto.getDateOfSubmission())
                .setApplicationStatus(dto.isApplicationStatus())
                .setForeignLanguage(dto.getForeignLanguage())
                .setVacancy(dto.getVacancy())
                .setEducation(dto.getEducation());
    }
}
