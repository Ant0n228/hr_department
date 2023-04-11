package com.anton.hr_department.controller.api;

import com.anton.hr_department.dto.RequirementsDTO;
import com.anton.hr_department.service.RequirementsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/requirement")
public class RequirementController {
    @Autowired
    RequirementsService requirementsService;

    @PostMapping("/create")
    public void createRequirement(@RequestBody RequirementsDTO requirementsDTO) {
        requirementsService.saveRequirements(requirementsDTO);
    }

    @GetMapping("/view")
    public List<RequirementsDTO> getRequirement() {
        return requirementsService.getAllRequirements();
    }
    @GetMapping("/view/{id}")
    public RequirementsDTO getRequirements(@PathVariable long id) {
        return requirementsService.getRequirements(id);
    }

    @PutMapping("/update")
    public void updateRequirements(@RequestBody RequirementsDTO requirementsDTO) {
        requirementsService.updateRequirements(requirementsDTO);
    }

    @DeleteMapping("delete/{id}")
    public void deleteRequirements(@PathVariable long id) {
        requirementsService.deleteRequirements(id);
    }
}
