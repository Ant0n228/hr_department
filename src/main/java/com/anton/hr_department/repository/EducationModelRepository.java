package com.anton.hr_department.repository;

import com.anton.hr_department.model.EducationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EducationModelRepository extends JpaRepository<EducationModel, Long> {
    List<EducationModel> findEducationModelBySpecialization(String specialization);
}
