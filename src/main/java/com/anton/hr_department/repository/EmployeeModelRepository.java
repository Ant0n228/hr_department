package com.anton.hr_department.repository;

import com.anton.hr_department.model.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeModelRepository extends JpaRepository<EmployeeModel, Long> {

    List<EmployeeModel> findByFio(String fio);
    EmployeeModel findByEmail(String email);
    List<EmployeeModel> findByPosition(String position);

}
