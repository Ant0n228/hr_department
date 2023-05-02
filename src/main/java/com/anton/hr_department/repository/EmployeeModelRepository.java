package com.anton.hr_department.repository;

import com.anton.hr_department.model.EmployeeModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeModelRepository extends CrudRepository<EmployeeModel, Long>{
    List<EmployeeModel> findEmployeeModelByFio(String fio);
    List<EmployeeModel> findEmployeeModelByPosition(String position);
}
