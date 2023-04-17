package com.anton.hr_department.service;


import com.anton.hr_department.dto.VacancyDTO;
import com.anton.hr_department.dto.VacancyWithRequirementsDTO;
import com.anton.hr_department.dto.mapper.VacancyDTOMapper;
import com.anton.hr_department.dto.mapper.VacancyWithRequirementsDTOMapper;
import com.anton.hr_department.model.RequirementsModel;
import com.anton.hr_department.model.VacancyModel;
import com.anton.hr_department.model.mapper.VacancyModelMapper;
import com.anton.hr_department.model.mapper.VacancyWithRequirementsModelMapper;
import com.anton.hr_department.repository.RequirementsModelRepository;
import com.anton.hr_department.repository.VacancyModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VacancyService {
    VacancyModelRepository vacancyModelRepository;
    RequirementsModelRepository requirementsModelRepository;

    @Autowired
    public VacancyService(VacancyModelRepository vacancyModelRepository,
                          RequirementsModelRepository requirementsModelRepository) {
        this.vacancyModelRepository = vacancyModelRepository;
        this.requirementsModelRepository = requirementsModelRepository;
    }

    public void saveVacancy(VacancyDTO vacancyDTO) {
        VacancyModel vacancyModel = VacancyModelMapper.mapToModel(vacancyDTO);
        vacancyModelRepository.save(vacancyModel);
    }

    public void saveVacancyWithRequirement(VacancyWithRequirementsDTO vacancyWithRequirementsDTO) {
        RequirementsModel requirementsModel = VacancyWithRequirementsModelMapper.mapToRequirementModel(vacancyWithRequirementsDTO);
        requirementsModelRepository.save(requirementsModel);
        VacancyModel vacancyModel = VacancyWithRequirementsModelMapper.mapToVacancyModel(vacancyWithRequirementsDTO);
        vacancyModelRepository.save(vacancyModel);
    }

    public List<VacancyDTO> getAllVacancy() {
        Iterable<VacancyModel> vacancies = vacancyModelRepository.findAll();
        List<VacancyDTO> vacancyDTOS = new ArrayList<>();

        vacancies.forEach(vacancy -> vacancyDTOS.add(VacancyDTOMapper.mapToDTO(vacancy)));

        return vacancyDTOS;
    }

    public VacancyWithRequirementsDTO getVacancyWithRequirement(long idVacancy) {
        Optional<VacancyModel> vacancyModel = vacancyModelRepository.findById(idVacancy);
        Optional<RequirementsModel> requirementsModel = requirementsModelRepository.findById(vacancyModel.get().getIdRequirements());

        return VacancyWithRequirementsDTOMapper.mapToDTO(vacancyModel.get(), requirementsModel.get());
    }


    public VacancyDTO getVacancy(long idVacancy) {
        Optional<VacancyModel> vacancyModel = vacancyModelRepository.findById(idVacancy);
        return VacancyDTOMapper.mapToDTO(vacancyModel.get());
    }


    public void updateVacancy(VacancyDTO vacancyDTO) {
        VacancyModel vacancyModel = VacancyModelMapper.mapToModel(vacancyDTO);
        vacancyModelRepository.save(vacancyModel);
    }

    public void deleteVacancy(long idVacancy) {
        Optional<VacancyModel> vacancyModel = vacancyModelRepository.findById(idVacancy);
        vacancyModelRepository.delete(vacancyModel.get());
    }
}
