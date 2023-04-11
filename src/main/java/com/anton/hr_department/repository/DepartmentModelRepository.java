package com.anton.hr_department.repository;

import com.anton.hr_department.model.DepartmentModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentModelRepository extends CrudRepository<DepartmentModel, Long> {
}
