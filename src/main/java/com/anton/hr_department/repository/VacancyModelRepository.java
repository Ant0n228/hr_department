package com.anton.hr_department.repository;

import com.anton.hr_department.model.VacancyModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VacancyModelRepository extends CrudRepository<VacancyModel, Long> {
}
