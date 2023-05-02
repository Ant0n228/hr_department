package com.anton.hr_department.service;


import com.anton.hr_department.dto.VacancyDTO;
import com.anton.hr_department.dto.VacancyWithRequirementsDTO;
import com.anton.hr_department.dto.mapper.VacancyDTOMapper;
import com.anton.hr_department.dto.mapper.VacancyWithRequirementsDTOMapper;
import com.anton.hr_department.model.RequirementsModel;
import com.anton.hr_department.model.VacancyModel;
import com.anton.hr_department.model.mapper.VacancyWithRequirementsModelMapper;
import com.anton.hr_department.repository.RequirementsModelRepository;
import com.anton.hr_department.repository.VacancyModelRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class VacancyService {
    private final VacancyModelRepository vacancyModelRepository;
    private final RequirementsModelRepository requirementsModelRepository;

    public List<VacancyDTO> getAllVacancy() {
        Iterable<VacancyModel> vacancies = vacancyModelRepository.findAll();
        List<VacancyDTO> vacancyDTOS = new ArrayList<>();

        vacancies.forEach(vacancy -> vacancyDTOS.add(VacancyDTOMapper.mapToDTO(vacancy)));

        return vacancyDTOS;
    }

    public void deleteVacancy(long idVacancy) {
        Optional<VacancyModel> vacancyModel = vacancyModelRepository.findById(idVacancy);
        vacancyModelRepository.delete(vacancyModel.get());
        log.info("Deleting {}", vacancyModel);
    }

    public void saveVacancyWithRequirement(VacancyWithRequirementsDTO vacancyWithRequirementsDTO) {
        RequirementsModel requirementsModel =
                VacancyWithRequirementsModelMapper.mapToRequirementModel(vacancyWithRequirementsDTO);

        // logging. we've just saved a new value
        requirementsModelRepository.save(requirementsModel);
        log.info("Saving new {}", requirementsModel);

        VacancyModel vacancyModel =
                VacancyWithRequirementsModelMapper.mapToVacancyModel(requirementsModel.getIdRequirements(),
                        vacancyWithRequirementsDTO);

        // logging. we've just saved a new value
        vacancyModelRepository.save(vacancyModel);
        log.info("Saving new {}", vacancyModel);
    }

    public VacancyWithRequirementsDTO getVacancyWithRequirement(long idVacancy) {
        Optional<VacancyModel> vacancyModel = vacancyModelRepository.findById(idVacancy);
        Optional<RequirementsModel> requirementsModel = requirementsModelRepository.findById(vacancyModel.get().getIdRequirements());

        return VacancyWithRequirementsDTOMapper.mapToDTO(vacancyModel.get(), requirementsModel.get());
    }

    public void updateVacancyWithRequirement(VacancyWithRequirementsDTO vacancyWithRequirementsDTO) {
        RequirementsModel requirementsModel =
                VacancyWithRequirementsModelMapper.mapToRequirementModel(vacancyWithRequirementsDTO);
        requirementsModelRepository.save(requirementsModel);

        VacancyModel vacancyModel =
                VacancyWithRequirementsModelMapper.mapToVacancyModel(requirementsModel.getIdRequirements(),
                        vacancyWithRequirementsDTO);
        vacancyModelRepository.save(vacancyModel);
    }

    public List<VacancyDTO> findVacancyByTitle(String title) {

        Iterable<VacancyModel> vacancyModels = title != null ?
                vacancyModelRepository.findVacancyModelsByJobTitle(title) :
                vacancyModelRepository.findAll();

        List<VacancyDTO> vacancyDTOS = new ArrayList<>();
        vacancyModels.forEach(vacancy -> vacancyDTOS.add(VacancyDTOMapper.mapToDTO(vacancy)));
        return vacancyDTOS;
    }
}
