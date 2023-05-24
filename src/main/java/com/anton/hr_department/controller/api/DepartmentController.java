package com.anton.hr_department.controller.api;

import com.anton.hr_department.model.DepartmentModel;
import com.anton.hr_department.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/department")
@RequiredArgsConstructor
@PreAuthorize("hasAnyAuthority('ROLE_CHIEF', 'ROLE_DEPARTMENT_ENGINEER', 'ROLE_USER')")
public class DepartmentController {
    private final DepartmentService departmentService;
    private final AppController appController;

    @GetMapping("/view")
    public String getAllDepartment(Model model) {
        model.addAttribute("departments", departmentService.getAllDepartments());
        model.addAttribute("user", appController.getUser());
        return "departments";
    }

    @GetMapping("/view/{id}")

    public String getDepartment(@PathVariable long id, Model model) {
        model.addAttribute("department", departmentService.getDepartment(id));
        model.addAttribute("employees", departmentService.getDepartment(id).getEmployeeModel());
        model.addAttribute("user", appController.getUser());
        return "department-info";
    }

    @GetMapping("/search")
    public String searchByDepartmentName(@RequestParam(name="departmentName", required = false) String departmentName,
                                         Model model) {
        model.addAttribute("departments", departmentService.findDepartmentByDepartmentName(departmentName));
        model.addAttribute("user", appController.getUser());
        return "departments";
    }

    @PostMapping("/create")
    @PreAuthorize("hasAnyAuthority('ROLE_CHIEF', 'ROLE_DEPARTMENT_ENGINEER')")
    public String createDepartment(DepartmentModel departmentModel) {
        departmentService.saveDepartment(departmentModel);
        return "redirect:/department/view";
    }


    @PutMapping("/update")
    @PreAuthorize("hasAnyAuthority('ROLE_CHIEF', 'ROLE_DEPARTMENT_ENGINEER')")
    public String updateDepartment(DepartmentModel departmentModel) {
        departmentService.updateDepartment(departmentModel);
        return "redirect:/department/view";
    }

    @PostMapping("delete/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_CHIEF', 'ROLE_DEPARTMENT_ENGINEER')")
    public String deleteDepartment(@PathVariable long id) {
        departmentService.deleteDepartment(id);
        return "redirect:/department/view";
    }
}
