package com.anton.hr_department.service;

import com.anton.hr_department.dto.EducationDTO;
import com.anton.hr_department.dto.mapper.EducationDTOMapper;
import com.anton.hr_department.model.EducationModel;
import com.anton.hr_department.model.mapper.EducationModelMapper;
import com.anton.hr_department.repository.EducationModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EducationService {
    @Autowired
    EducationModelRepository educationModelRepository;

    public void saveEducation(EducationDTO educationDTO) {
        EducationModel educationModel = EducationModelMapper.mapToModel(educationDTO);
        educationModelRepository.save(educationModel);
    }

    public List<EducationDTO> getAllEducation() {
        Iterable<EducationModel> educations = educationModelRepository.findAll();
        List<EducationDTO> educationDTOS = new ArrayList<>();

        educations.forEach(education -> {
            educationDTOS.add(EducationDTOMapper.mapToDTO(education));
        });

        return educationDTOS;
    }
}
