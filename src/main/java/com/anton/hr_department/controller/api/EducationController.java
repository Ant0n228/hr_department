package com.anton.hr_department.controller.api;

import com.anton.hr_department.dto.EducationDTO;
import com.anton.hr_department.service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/education")
public class EducationController {
    @Autowired
    EducationService educationService;

    @PostMapping("/create")
    public void createEducation(@RequestBody EducationDTO educationDTO) {
        educationService.saveEducation(educationDTO);
    }

    @GetMapping("/view")
    public List<EducationDTO> getEducation() {
        List<EducationDTO> educationDTOS = educationService.getAllEducation();
        return educationDTOS;
    }
}
