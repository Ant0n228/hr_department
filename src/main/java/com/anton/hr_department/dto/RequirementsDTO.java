package com.anton.hr_department.dto;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class RequirementsDTO {
    private long idRequirements;
    private String programmingLanguage;
    private String framework;
    private String additionalSkill;
}
