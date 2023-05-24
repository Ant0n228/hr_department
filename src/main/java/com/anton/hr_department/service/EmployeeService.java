package com.anton.hr_department.service;

import com.anton.hr_department.dto.EmployeeDTO;
import com.anton.hr_department.dto.mapper.EmployeeDTOMapper;
import com.anton.hr_department.model.DepartmentModel;
import com.anton.hr_department.model.EmployeeModel;
import com.anton.hr_department.model.VacancyModel;
import com.anton.hr_department.repository.DepartmentModelRepository;
import com.anton.hr_department.repository.EducationModelRepository;
import com.anton.hr_department.repository.EmployeeModelRepository;
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
public class EmployeeService {
    private final EmployeeModelRepository employeeModelRepository;
    private final DepartmentModelRepository departmentModelRepository;
    private final VacancyModelRepository vacancyModelRepository;
    private final EducationModelRepository educationModelRepository;

    private final EmployeeDTOMapper employeeDTOMapper;

    public void saveEmployee(EmployeeDTO employeeDTO, Long idDepartment, Long idVacancy) {
        EmployeeModel employeeModel = employeeDTOMapper.mapToModel(employeeDTO);
        DepartmentModel departmentModel = departmentModelRepository.findById(idDepartment).orElse(null);
        VacancyModel vacancyModel = vacancyModelRepository.findById(idVacancy).orElse(null);
        employeeModel.setDepartment(departmentModel);
        employeeModel.setVacancy(vacancyModel);
        educationModelRepository.save(employeeModel.getEducation());
        employeeModelRepository.save(employeeModel);
    }


    public List<EmployeeDTO> getAllEmployees() {
        Iterable<EmployeeModel> employees = employeeModelRepository.findAll();
        List<EmployeeDTO> employeeDTOS = new ArrayList<>();

        employees.forEach(employee -> employeeDTOS.add(employeeDTOMapper.mapToDTO(employee)));

        return employeeDTOS;
    }

    public EmployeeDTO getEmployee(long idEmployee) {
        Optional<EmployeeModel> employeeModel = employeeModelRepository.findById(idEmployee);
        return employeeModel.map(employeeDTOMapper::mapToDTO).orElse(null);
    }

    public void updateEmployee(EmployeeDTO employeeDTO) {
        EmployeeModel employeeModel = employeeDTOMapper.mapToModel(employeeDTO);
        employeeModelRepository.save(employeeModel);
    }

    public void deleteEmployee(long idEmployee) {
        Optional<EmployeeModel> employeeModel = employeeModelRepository.findById(idEmployee);
        employeeModel.ifPresent(employeeModelRepository::delete);
    }

    public EmployeeDTO findEmployeeByFio(String fio) {
        return employeeDTOMapper.mapToDTO(employeeModelRepository.findByFio(fio));
    }

    public EmployeeDTO findEmployeeByEmail(String email) {
        return employeeDTOMapper.mapToDTO(employeeModelRepository.findByEmail(email));
    }

    public List<EmployeeDTO> findEmployeeByPosition(String position) {
        Iterable<EmployeeModel> employeeModels = position != null ?
                employeeModelRepository.findByPosition(position) :
                employeeModelRepository.findAll();

        List<EmployeeDTO> employeeDTOS = new ArrayList<>();
        employeeModels.forEach(employeeModel -> employeeDTOS.add(employeeDTOMapper.mapToDTO(employeeModel)));
        return employeeDTOS;
    }

}
