package com.anton.hr_department.controller.api;

import com.anton.hr_department.dto.DepartmentDTO;
import com.anton.hr_department.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @PostMapping("/create")
    public void createDepartment(@RequestBody DepartmentDTO departmentDTO) {
        departmentService.saveDepartment(departmentDTO);
    }

    @GetMapping("/view")
    public List<DepartmentDTO> getAllDepartment() {
        return departmentService.getAllDepartment();
    }

    @GetMapping("/view/{id}")
    public DepartmentDTO getDepartment(@PathVariable long id) {
        return departmentService.getDepartment(id);
    }

    @PutMapping("/update")
    public void updateDepartment(@RequestBody DepartmentDTO departmentDTO) {
        departmentService.updateDepartment(departmentDTO);
    }

    @DeleteMapping("delete/{id}")
    public void deleteDepartment(@PathVariable long id) {
        departmentService.deleteDepartment(id);
    }
}
