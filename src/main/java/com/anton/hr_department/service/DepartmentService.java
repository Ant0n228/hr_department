package com.anton.hr_department.service;

import com.anton.hr_department.dto.DepartmentDTO;
import com.anton.hr_department.dto.mapper.DepartmentDTOMapper;
import com.anton.hr_department.model.DepartmentModel;
import com.anton.hr_department.model.mapper.DepartmentModelMapper;
import com.anton.hr_department.repository.DepartmentModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    @Autowired
    DepartmentModelRepository departmentModelRepository;

    public void saveDepartment(DepartmentDTO departmentDTO) {
        DepartmentModel departmentModel = DepartmentModelMapper.mapToModel(departmentDTO);
        departmentModelRepository.save(departmentModel);
    }

    public List<DepartmentDTO> getAllDepartment() {
        Iterable<DepartmentModel> departments = departmentModelRepository.findAll();
        List<DepartmentDTO> departmentDTOS = new ArrayList<>();

        departments.forEach(department -> {
            departmentDTOS.add(DepartmentDTOMapper.mapToDTO(department));
        });

        return departmentDTOS;
    }

    public DepartmentDTO getDepartment(long idDepartment) {
        Optional<DepartmentModel> departmentModel = departmentModelRepository.findById(idDepartment);
        return DepartmentDTOMapper.mapToDTO(departmentModel.get());
    }

    public void updateDepartment(DepartmentDTO departmentDTO) {
        DepartmentModel departmentModel = DepartmentModelMapper.mapToModel(departmentDTO);
        departmentModelRepository.save(departmentModel);
    }

    public void deleteDepartment(long idDepartment) {
        Optional<DepartmentModel> departmentModel = departmentModelRepository.findById(idDepartment);
        departmentModelRepository.delete(departmentModel.get());
    }
}
