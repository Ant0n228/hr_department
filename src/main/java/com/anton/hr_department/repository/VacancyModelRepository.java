package com.anton.hr_department.repository;

import com.anton.hr_department.model.VacancyModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VacancyModelRepository extends JpaRepository<VacancyModel, Long> {
    List<VacancyModel> findVacancyModelsByJobTitle(String title);
}
