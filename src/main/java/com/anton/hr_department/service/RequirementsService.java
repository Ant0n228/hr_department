package com.anton.hr_department.service;

import com.anton.hr_department.dto.RequirementsDTO;
import com.anton.hr_department.dto.mapper.RequirementsDTOMapper;
import com.anton.hr_department.model.RequirementsModel;
import com.anton.hr_department.model.mapper.RequirementsModelMapper;
import com.anton.hr_department.repository.RequirementsModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RequirementsService {
    @Autowired
    RequirementsModelRepository requirementsModelRepository;
    public void saveRequirements(RequirementsDTO requirementsDTO) {
        RequirementsModel requirementsModel = RequirementsModelMapper.mapToModel(requirementsDTO);
        requirementsModelRepository.save(requirementsModel);
    }

    public List<RequirementsDTO> getAllRequirements() {
        Iterable<RequirementsModel> requirements = requirementsModelRepository.findAll();
        List<RequirementsDTO> requirementsDTOS = new ArrayList<>();

        requirements.forEach(requirement -> {
            requirementsDTOS.add(RequirementsDTOMapper.mapToDTO(requirement));
        });

        return requirementsDTOS;
    }

    public RequirementsDTO getRequirements(long idRequirements) {
        Optional<RequirementsModel> requirementsModel = requirementsModelRepository.findById(idRequirements);
        return RequirementsDTOMapper.mapToDTO(requirementsModel.get());
    }

    public void updateRequirements(RequirementsDTO requirementsDTO) {
        RequirementsModel requirementsModel = RequirementsModelMapper.mapToModel(requirementsDTO);
        requirementsModelRepository.save(requirementsModel);
    }

    public void deleteRequirements(long idRequirements) {
        Optional<RequirementsModel> requirementsModel = requirementsModelRepository.findById(idRequirements);
        requirementsModelRepository.delete(requirementsModel.get());
    }
}
