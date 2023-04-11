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
        List<RequirementsDTO> requirementsDTOS = requirementsService.getAllRequirements();
        return requirementsDTOS;
    }
}
