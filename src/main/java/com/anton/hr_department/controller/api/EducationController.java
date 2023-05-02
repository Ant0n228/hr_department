package com.anton.hr_department.controller.api;

import com.anton.hr_department.model.EducationModel;
import com.anton.hr_department.service.EducationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/education")
@RequiredArgsConstructor
public class EducationController {
    private final EducationService educationService;

    @PostMapping("/create")
    public void createEducation(@RequestBody EducationModel educationModel) {
        educationService.saveEducation(educationModel);
    }

    @GetMapping("/view")
    public List<EducationModel> getEducation() {
        return educationService.getAllEducation();
    }

    @GetMapping("/view/{id}")
    public EducationModel getEducation(@PathVariable long id) {
        return educationService.getEducation(id);
    }
    @PutMapping("/update")
    public void updateEducation(@RequestBody EducationModel educationModel) {
        educationService.updateEducation(educationModel);
    }

    @DeleteMapping("delete/{id}")
    public void deleteEducation(@PathVariable long id) {
        educationService.deleteEducation(id);
    }
}
