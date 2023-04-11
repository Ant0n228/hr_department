package com.anton.hr_department.service;


import com.anton.hr_department.dto.VacancyDTO;
import com.anton.hr_department.dto.mapper.VacancyDTOMapper;
import com.anton.hr_department.model.VacancyModel;
import com.anton.hr_department.model.mapper.VacancyModelMapper;
import com.anton.hr_department.repository.VacancyModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VacancyService {
    @Autowired
    VacancyModelRepository vacancyModelRepository;

    public void saveVacancy(VacancyDTO vacancyDTO) {
        VacancyModel vacancyModel = VacancyModelMapper.mapToModel(vacancyDTO);
        vacancyModelRepository.save(vacancyModel);
    }

    public List<VacancyDTO> getAllVacancy() {
        Iterable<VacancyModel> vacancies = vacancyModelRepository.findAll();
        List<VacancyDTO> vacancyDTOS = new ArrayList<>();

        vacancies.forEach(vacancy -> {
            vacancyDTOS.add(VacancyDTOMapper.mapToDTO(vacancy));
        });

        return vacancyDTOS;
    }
}
