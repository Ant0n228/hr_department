package com.anton.hr_department.dto.mapper;

import com.anton.hr_department.dto.EducationDTO;
import com.anton.hr_department.model.EducationModel;

public class EducationDTOMapper {

    public static EducationDTO mapToDTO(EducationModel model) {
        return new EducationDTO()
                .setIdEducation(model.getIdEducation())
                .setEducationalInstitution(model.getEducationalInstitution())
                .setFaculty(model.getFaculty())
                .setSpecialization(model.getSpecialization())
                .setDateOfAdmission(model.getDateOfAdmission())
                .setDateOfGraduation(model.getDateOfGraduation());
    }
}