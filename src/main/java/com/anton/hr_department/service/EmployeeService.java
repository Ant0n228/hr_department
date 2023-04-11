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

@Service
public class EmployeeService {
    @Autowired
    EmployeeModelRepository employeeModelRepository;

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
}
