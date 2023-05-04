package com.anton.hr_department.service;

import com.anton.hr_department.dto.EmployeeDTO;
import com.anton.hr_department.dto.mapper.EmployeeDTOMapper;
import com.anton.hr_department.model.EmployeeModel;
import com.anton.hr_department.model.mapper.EmployeeModelMapper;
import com.anton.hr_department.repository.EmployeeModelRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeModelRepository employeeModelRepository;

    public void saveEmployee(EmployeeDTO employeeDTO) {
        EmployeeModel employeeModel = EmployeeModelMapper.mapToModel(employeeDTO);
        employeeModelRepository.save(employeeModel);
        log.info("Saving new {} ", employeeModel);
    }

    public List<EmployeeDTO> getAllEmployee() {
        Iterable<EmployeeModel> employees = employeeModelRepository.findAll();
        List<EmployeeDTO> employeeDTOS = new ArrayList<>();

        employees.forEach(employee -> employeeDTOS.add(EmployeeDTOMapper.mapToDTO(employee)));

        return employeeDTOS;
    }

    public EmployeeDTO getEmployee(long idEmployee) {
        Optional<EmployeeModel> employeeModel = employeeModelRepository.findById(idEmployee);
        log.info("You take {}", employeeModel.get());
        return EmployeeDTOMapper.mapToDTO(employeeModel.get());
    }

    public void updateEmployee(EmployeeDTO employeeDTO) {
        EmployeeModel employeeModel = EmployeeModelMapper.mapToModel(employeeDTO);
        employeeModelRepository.save(employeeModel);
    }

    public void deleteEmployee(long idEmployee) {
        Optional<EmployeeModel> employeeModel = employeeModelRepository.findById(idEmployee);
        employeeModelRepository.delete(employeeModel.get());
        log.info("Deleting {} ", employeeModel);
    }

    // TODO this two method are quite similar
    public List<EmployeeDTO> findEmployeeByFio(String fio) {
        Iterable<EmployeeModel> employeeModels = fio != null ?
                employeeModelRepository.findEmployeeModelByFio(fio) :
                employeeModelRepository.findAll();

        List<EmployeeDTO> employeeDTOS = new ArrayList<>();
        employeeModels.forEach(employeeModel -> employeeDTOS.add(EmployeeDTOMapper.mapToDTO(employeeModel)));
        return employeeDTOS;
    }

    public List<EmployeeDTO> findEmployeeByPosition(String position) {
        Iterable<EmployeeModel> employeeModels = position != null ?
                employeeModelRepository.findEmployeeModelByPosition(position) :
                employeeModelRepository.findAll();

        List<EmployeeDTO> employeeDTOS = new ArrayList<>();
        employeeModels.forEach(employeeModel -> employeeDTOS.add(EmployeeDTOMapper.mapToDTO(employeeModel)));
        return employeeDTOS;
    }
}
