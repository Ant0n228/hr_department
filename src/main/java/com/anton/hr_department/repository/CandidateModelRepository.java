package com.anton.hr_department.repository;

import com.anton.hr_department.model.CandidateModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateModelRepository extends CrudRepository<CandidateModel, Long> {
}
