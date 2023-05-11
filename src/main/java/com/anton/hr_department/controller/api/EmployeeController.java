package com.anton.hr_department.controller.api;

import com.anton.hr_department.dto.EmployeeDTO;
import com.anton.hr_department.service.DepartmentService;
import com.anton.hr_department.service.EmployeeService;
import com.anton.hr_department.service.VacancyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employee")
@Slf4j
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;
    private final DepartmentService departmentService;
    private final VacancyService vacancyService;

    @GetMapping("/view")
    public String getEmployees(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployee());
        model.addAttribute("departments", departmentService.getAllDepartment());
        model.addAttribute("vacancies", vacancyService.getAllVacancy());
        return "employees";
    }
    @GetMapping("/view/{id}")
    public String getEmployee(@PathVariable long id, Model model) {
        model.addAttribute("employee", employeeService.getEmployee(id));
        return "employee-info";
    }

    @GetMapping("/search/fio")
    public String  searchEmployeeByFio(@RequestParam(name = "fio", required = false)
                                       String fio, Model model){
        model.addAttribute("employees", employeeService.findEmployeeByFio(fio));
        return "employees";
    }

    @GetMapping("/search/position")
    public String searchEmployeeByPosition(@RequestParam(name="position", required = false)
                                           String position, Model model) {
        model.addAttribute("employees", employeeService.findEmployeeByPosition(position));
        return "employees";
    }

    @PostMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable long id) {
        employeeService.deleteEmployee(id);
        return "redirect:/employee/view";
    }

    @PostMapping("/create")
    public String createEmployee(EmployeeDTO employeeDTO, @RequestParam Long idDepartment, @RequestParam Long idVacancy) {
        employeeService.saveEmployee(employeeDTO, idDepartment, idVacancy);
        return "redirect:/employee/view";
    }

    @PutMapping("/update")
    public String updateEmployee(EmployeeDTO employeeDTO) {
        employeeService.updateEmployee(employeeDTO);
        return "redirect:/employee/view";
    }

}
