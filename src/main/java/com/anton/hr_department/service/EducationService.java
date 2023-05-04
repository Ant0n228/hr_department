package com.anton.hr_department.service;

import com.anton.hr_department.model.EducationModel;
import com.anton.hr_department.repository.EducationModelRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class EducationService {
    private final EducationModelRepository educationModelRepository;

    public void saveEducation(EducationModel educationModel) {
        educationModelRepository.save(educationModel);
        log.info("Saving {} ", educationModel);
    }

    public List<EducationModel> getAllEducation() {
        return educationModelRepository.findAll();
    }

    public EducationModel getEducation(long idEducation) {
        Optional<EducationModel> educationModel = educationModelRepository.findById(idEducation);
        return educationModel.get();
    }
    public void updateEducation(EducationModel educationModel) {
        educationModelRepository.save(educationModel);
    }

    public void deleteEducation(long idEducation) {
        Optional<EducationModel> educationModel = educationModelRepository.findById(idEducation);
        educationModelRepository.delete(educationModel.get());
        log.info("Deleting {} ", educationModel);
    }

    public List<EducationModel> findEducationBySpecialization(String specialization) {
        log.info("Search {}", specialization);
        return specialization != null ?
                educationModelRepository.findEducationModelBySpecialization(specialization) :
                educationModelRepository.findAll();
    }
}
