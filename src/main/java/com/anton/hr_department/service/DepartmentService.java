package com.anton.hr_department.service;

import com.anton.hr_department.model.DepartmentModel;
import com.anton.hr_department.repository.DepartmentModelRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class DepartmentService {
    private final DepartmentModelRepository departmentModelRepository;

    public void saveDepartment(DepartmentModel departmentModel) {
        departmentModelRepository.save(departmentModel);
        log.info("Saving {} ", departmentModel);
    }

    public List<DepartmentModel> getAllDepartments() {
        return departmentModelRepository.findAll();
    }

    public DepartmentModel getDepartment(long idDepartment) {
        return departmentModelRepository.findById(idDepartment).orElse(null);
    }

    public void updateDepartment(DepartmentModel departmentModel) {
        departmentModelRepository.save(departmentModel);
    }

    public void deleteDepartment(long idDepartment) {
        Optional<DepartmentModel> departmentModel = departmentModelRepository.findById(idDepartment);
        departmentModel.ifPresent(departmentModelRepository::delete);
    }

    public List<DepartmentModel> findDepartmentByDepartmentName(String departmentName) {
        return departmentName != null ?
                departmentModelRepository.findDepartmentModelByDepartmentName(departmentName) :
                departmentModelRepository.findAll();
    }
}
