package com.anton.hr_department.dto.mapper;

import com.anton.hr_department.dto.RequirementsDTO;
import com.anton.hr_department.model.RequirementsModel;

public class RequirementsDTOMapper {

    public static RequirementsDTO mapToDTO(RequirementsModel model) {
        return new RequirementsDTO()
                .setIdRequirements(model.getIdRequirements())
                .setProgrammingLanguage(model.getProgrammingLanguage())
                .setFramework(model.getFramework())
                .setAdditionalSkill(model.getAdditionalSkill());
    }
}
