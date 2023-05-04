package com.anton.hr_department.repository;

import com.anton.hr_department.model.DepartmentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentModelRepository extends JpaRepository<DepartmentModel, Long> {
    List<DepartmentModel> findDepartmentModelByDepartmentName(String DepartmentName);
}
