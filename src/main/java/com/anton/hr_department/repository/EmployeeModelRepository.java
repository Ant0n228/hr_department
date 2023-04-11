package com.anton.hr_department.repository;

import com.anton.hr_department.model.EmployeeModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeModelRepository extends CrudRepository<EmployeeModel, Long>{
}
