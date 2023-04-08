package com.anton.hr_department.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class RequirementsModel {
    private long idRequirements;
    private String programmingLanguage;
    private String framework;
    private String additionalSkill;
}
