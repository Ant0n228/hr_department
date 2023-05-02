package com.anton.hr_department.controller.api;

import com.anton.hr_department.dto.EmployeeDTO;
import com.anton.hr_department.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping("/view")
    public String getEmployee(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployee());
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
    public String createEmployee(EmployeeDTO employeeDTO) {
        employeeService.saveEmployee(employeeDTO);
        return "redirect:/employee/view";
    }

    @PutMapping("/update")
    public String updateEmployee(EmployeeDTO employeeDTO) {
        employeeService.updateEmployee(employeeDTO);
        return "redirect:/employee/view";
    }

}
