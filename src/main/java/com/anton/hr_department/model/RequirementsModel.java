package com.anton.hr_department.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Entity
@Table(name = "requirements_for_candidates")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class RequirementsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRequirements;

    @Column(columnDefinition = "text")
    private String requirements;

    @Column(columnDefinition = "text")
    private String jobDescription;
}
