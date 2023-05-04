package com.anton.hr_department.controller.api;

import com.anton.hr_department.model.DepartmentModel;
import com.anton.hr_department.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/department")
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;

    @GetMapping("/view")
    public String getAllDepartment(Model model) {
        model.addAttribute("departments", departmentService.getAllDepartment());
        return "departments";
    }

    @GetMapping("/view/{id}")
    public String getDepartment(@PathVariable long id, Model model) {
        model.addAttribute("department", departmentService.getDepartment(id));
        return "department-info";
    }

    @GetMapping("/search")
    public String searchByDepartmentName(@RequestParam(name="departmentName", required = false) String departmentName,
                                         Model model) {
        model.addAttribute("departments", departmentService.findDepartmentByDepartmentName(departmentName));
        return "departments";
    }

    @PostMapping("/create")
    public String createDepartment(DepartmentModel departmentModel) {
        departmentService.saveDepartment(departmentModel);
        return "redirect:/department/view";
    }


    @PutMapping("/update")
    public String updateDepartment(DepartmentModel departmentModel) {
        departmentService.updateDepartment(departmentModel);
        return "redirect:/department/view";
    }

    @PostMapping("delete/{id}")
    public String deleteDepartment(@PathVariable long id) {
        departmentService.deleteDepartment(id);
        return "redirect:/department/view";
    }
}
