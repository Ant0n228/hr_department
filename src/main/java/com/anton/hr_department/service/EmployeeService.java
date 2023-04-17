package com.anton.hr_department.service;

import com.anton.hr_department.dto.EmployeeDTO;
import com.anton.hr_department.dto.mapper.EmployeeDTOMapper;
import com.anton.hr_department.model.EmployeeModel;
import com.anton.hr_department.model.mapper.EmployeeModelMapper;
import com.anton.hr_department.repository.EmployeeModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    EmployeeModelRepository employeeModelRepository;

    @Autowired
    public EmployeeService(EmployeeModelRepository employeeModelRepository) {
        this.employeeModelRepository = employeeModelRepository;
    }

    public void saveEmployee(EmployeeDTO employeeDTO) {
        EmployeeModel employeeModel = EmployeeModelMapper.mapToModel(employeeDTO);
        employeeModelRepository.save(employeeModel);
    }

    public List<EmployeeDTO> getAllEmployee() {
        Iterable<EmployeeModel> employees = employeeModelRepository.findAll();
        List<EmployeeDTO> employeeDTOS = new ArrayList<>();

        employees.forEach(employee -> {
            employeeDTOS.add(EmployeeDTOMapper.mapToDTO(employee));
        });

        return employeeDTOS;
    }
    public EmployeeDTO getEmployee(long idEmployee) {
        Optional<EmployeeModel> employeeModel = employeeModelRepository.findById(idEmployee);
        return EmployeeDTOMapper.mapToDTO(employeeModel.get());
    }

    public void updateEmployee(EmployeeDTO employeeDTO) {
        EmployeeModel employeeModel = EmployeeModelMapper.mapToModel(employeeDTO);
        employeeModelRepository.save(employeeModel);
    }

    public void deleteEmployee(long idEmployee) {
        Optional<EmployeeModel> employeeModel = employeeModelRepository.findById(idEmployee);
        employeeModelRepository.delete(employeeModel.get());
    }
}
