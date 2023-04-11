package com.anton.hr_department.controller.api;

import com.anton.hr_department.dto.EmployeeDTO;
import com.anton.hr_department.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping("/create")
    public void createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        employeeService.saveEmployee(employeeDTO);
    }

    @GetMapping("/view")
    public List<EmployeeDTO> getEmployee() {
        return employeeService.getAllEmployee();
    }
    @GetMapping("/view/{id}")
    public EmployeeDTO getEmployee(@PathVariable long id) {
        return employeeService.getEmployee(id);
    }

    @PutMapping("/update")
    public void updateEmployee(@RequestBody EmployeeDTO employeeDTO) {
        employeeService.updateEmployee(employeeDTO);
    }

    @DeleteMapping("delete/{id}")
    public void deleteEmployee(@PathVariable long id) {
        employeeService.deleteEmployee(id);
    }
}
