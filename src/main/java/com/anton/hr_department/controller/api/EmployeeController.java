package com.anton.hr_department.controller.api;

import com.anton.hr_department.dto.EmployeeDTO;
import com.anton.hr_department.service.DepartmentService;
import com.anton.hr_department.service.EmployeeService;
import com.anton.hr_department.service.VacancyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employee")
@Slf4j
@RequiredArgsConstructor
@PreAuthorize("hasAnyAuthority('ROLE_CHIEF', 'ROLE_HR_SPECIALIST', 'ROLE_DEPARTMENT_ENGINEER', 'ROLE_USER')")
public class EmployeeController {
    private final EmployeeService employeeService;
    private final DepartmentService departmentService;
    private final VacancyService vacancyService;
    private final AppController appController;

    @GetMapping("/view")
    public String getEmployees(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployees());
        model.addAttribute("departments", departmentService.getAllDepartments());
        model.addAttribute("vacancies", vacancyService.getAllVacancys());
        model.addAttribute("user", appController.getUser());
        return "employees";
    }
    @GetMapping("/view/{id}")
    public String getEmployee(@PathVariable long id, Model model) {
        model.addAttribute("employee", employeeService.getEmployee(id));
        model.addAttribute("user", appController.getUser());
        return "employee-info";
    }

    @GetMapping("/search/fio")
    public String  searchEmployeeByFio(@RequestParam(name = "fio", required = false)
                                       String fio, Model model){
        model.addAttribute("position", employeeService.findEmployeeByFio(fio));
        model.addAttribute("user", appController.getUser());
        return "employees";
    }

    @GetMapping("/search/position")
    public String searchEmployeeByPosition(@RequestParam(name="position", required = false)
                                           String position, Model model) {
        model.addAttribute("employees", employeeService.findEmployeeByPosition(position));
        model.addAttribute("user", appController.getUser());
        return "employees";
    }

    @GetMapping("/search")
    public String searchEmployee(@RequestParam(name = "position", required = false) String position,
                                 @RequestParam(name = "fio", required = false) String fio,
                                 Model model) {
        model.addAttribute("employees", employeeService.findEmployeeByPosition(position));
        model.addAttribute("employees", employeeService.findEmployeeByFio(fio));
        model.addAttribute("user", appController.getUser());
        return "employees";
    }
    @PostMapping("/delete/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_CHIEF', 'ROLE_HR_SPECIALIST', 'ROLE_DEPARTMENT_ENGINEER')")
    public String deleteEmployee(@PathVariable long id) {
        employeeService.deleteEmployee(id);
        return "redirect:/employee/view";
    }

    @PostMapping("/create")
    @PreAuthorize("hasAnyAuthority('ROLE_CHIEF', 'ROLE_HR_SPECIALIST', 'ROLE_DEPARTMENT_ENGINEER')")
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
