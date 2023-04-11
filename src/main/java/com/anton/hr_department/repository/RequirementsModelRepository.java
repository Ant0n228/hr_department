package com.anton.hr_department.repository;

import com.anton.hr_department.model.RequirementsModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequirementsModelRepository extends CrudRepository<RequirementsModel, Long> {
}
