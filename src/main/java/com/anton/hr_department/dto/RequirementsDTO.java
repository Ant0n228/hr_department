package com.anton.hr_department.dto;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class RequirementsDTO {
    private Long idRequirements;
    private String requirements;
    private String jobDescription;
}
