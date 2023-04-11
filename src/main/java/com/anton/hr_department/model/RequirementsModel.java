package com.anton.hr_department.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Entity
@Table(name = "requirements_for_candidates")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class RequirementsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idRequirements;

    @Column(name = "programming_language")
    private String programmingLanguage;

    @Column(name = "framework")
    private String framework;

    @Column(name = "additional_skill")
    private String additionalSkill;
}
