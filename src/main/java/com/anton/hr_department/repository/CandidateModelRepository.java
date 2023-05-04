package com.anton.hr_department.repository;

import com.anton.hr_department.model.CandidateModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidateModelRepository extends JpaRepository<CandidateModel, Long> {
    List<CandidateModel> findCandidateModelByFio(String fio);
}
