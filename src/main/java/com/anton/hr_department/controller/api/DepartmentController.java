package com.anton.hr_department.controller.api;

import com.anton.hr_department.model.DepartmentModel;
import com.anton.hr_department.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;

    @PostMapping("/create")
    public void createDepartment(@RequestBody DepartmentModel departmentModel) {
        departmentService.saveDepartment(departmentModel);
    }

    @GetMapping("/view")
    public List<DepartmentModel> getAllDepartment() {
        return departmentService.getAllDepartment();
    }

    @GetMapping("/view/{id}")
    public DepartmentModel getDepartment(@PathVariable long id) {
        return departmentService.getDepartment(id);
    }

    @PutMapping("/update")
    public void updateDepartment(@RequestBody DepartmentModel departmentModel) {
        departmentService.updateDepartment(departmentModel);
    }

    @DeleteMapping("delete/{id}")
    public void deleteDepartment(@PathVariable long id) {
        departmentService.deleteDepartment(id);
    }
}
