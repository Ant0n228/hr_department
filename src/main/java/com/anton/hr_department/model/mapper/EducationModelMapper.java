package com.anton.hr_department.model.mapper;

import com.anton.hr_department.dto.EducationDTO;
import com.anton.hr_department.model.EducationModel;

public class EducationModelMapper {
    public static EducationModel mapToModel(EducationDTO dto) {
        return new EducationModel()
                .setIdEducation(dto.getIdEducation())
                .setEducationalInstitution(dto.getEducationalInstitution())
                .setFaculty(dto.getFaculty())
                .setSpecialization(dto.getSpecialization())
                .setDateOfAdmission(dto.getDateOfAdmission())
                .setDateOfGraduation(dto.getDateOfGraduation());
    }
}
