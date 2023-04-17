package com.anton.hr_department.controller.api;

import com.anton.hr_department.dto.EducationDTO;
import com.anton.hr_department.service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/education")
public class EducationController {
    EducationService educationService;

    @Autowired
    public EducationController(EducationService educationService) {
        this.educationService = educationService;
    }
    @PostMapping("/create")
    public void createEducation(@RequestBody EducationDTO educationDTO) {
        educationService.saveEducation(educationDTO);
    }

    @GetMapping("/view")
    public List<EducationDTO> getEducation() {
        return educationService.getAllEducation();
    }

    @GetMapping("/view/{id}")
    public EducationDTO getEducation(@PathVariable long id) {
        return educationService.getEducation(id);
    }
    @PutMapping("/update")
    public void updateEducation(@RequestBody EducationDTO educationDTO) {
        educationService.updateEducation(educationDTO);
    }

    @DeleteMapping("delete/{id}")
    public void deleteEducation(@PathVariable long id) {
        educationService.deleteEducation(id);
    }
}
