package com.anton.hr_department.service;


import com.anton.hr_department.model.RequirementsModel;
import com.anton.hr_department.model.VacancyModel;
import com.anton.hr_department.repository.RequirementsModelRepository;
import com.anton.hr_department.repository.VacancyModelRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class VacancyService {
    private final VacancyModelRepository vacancyModelRepository;
    private final RequirementsModelRepository requirementsModelRepository;

    public List<VacancyModel> getAllVacancy() {
        return vacancyModelRepository.findAll();
    }

    public VacancyModel getVacancy(long idVacancy) {
        return vacancyModelRepository.findById(idVacancy).orElse(null);
    }

    public void deleteVacancy(long idVacancy) {
        Optional<VacancyModel> vacancyModel = vacancyModelRepository.findById(idVacancy);
        vacancyModel.ifPresent(vacancyModelRepository::delete);
    }

    public void saveVacancy(VacancyModel vacancy) {
        RequirementsModel requirementsModel = vacancy.getRequirements();
        // logging. we've just saved a new value
        log.info("Saving new {}", requirementsModel);
        requirementsModelRepository.save(requirementsModel);
        // logging. we've just saved a new value
        log.info("Saving new {}", vacancy);
        vacancyModelRepository.save(vacancy);
    }

    public void update(VacancyModel vacancy) {
        RequirementsModel requirementsModel = vacancy.getRequirements();
        requirementsModelRepository.save(requirementsModel);
        vacancyModelRepository.save(vacancy);
    }

    public List<VacancyModel> findVacancyByTitle(String title) {
        return title != null ?
                vacancyModelRepository.findVacancyModelsByJobTitle(title) :
                vacancyModelRepository.findAll();
    }
}
