package com.anton.hr_department.repository;

import com.anton.hr_department.model.RequirementsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequirementsModelRepository extends JpaRepository<RequirementsModel, Long> {
}
