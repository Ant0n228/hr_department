package com.anton.hr_department.repository;

import com.anton.hr_department.model.EducationModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationModelRepository extends CrudRepository<EducationModel, Long> {
}
