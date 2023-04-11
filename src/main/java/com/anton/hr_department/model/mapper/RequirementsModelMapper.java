package com.anton.hr_department.model.mapper;

import com.anton.hr_department.dto.RequirementsDTO;
import com.anton.hr_department.model.RequirementsModel;

public class RequirementsModelMapper {

    public static RequirementsModel mapToModel(RequirementsDTO dto) {
        return new RequirementsModel()
                .setIdRequirements(dto.getIdRequirements())
                .setProgrammingLanguage(dto.getProgrammingLanguage())
                .setFramework(dto.getFramework())
                .setAdditionalSkill(dto.getAdditionalSkill());
    }
}
