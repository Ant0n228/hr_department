package com.anton.hr_department.controller.api;

import com.anton.hr_department.model.EducationModel;
import com.anton.hr_department.service.EducationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/education")
@RequiredArgsConstructor
public class EducationController {
    private final EducationService educationService;

    @GetMapping("/view")
    public String getEducation(Model model) {
        model.addAttribute("educations", educationService.getAllEducation());
        return "educations";
    }

    @GetMapping("/view/{id}")
    public String getEducation(@PathVariable long id, Model model) {
        model.addAttribute("education", educationService.getEducation(id));
        return "education-info";
    }

    @GetMapping("/search")
    public String searchEducationBySpecialization(@RequestParam(name="specialization", required = false)
                                                      String specialization, Model model) {
        model.addAttribute("educations", educationService.findEducationBySpecialization(specialization));
        return "educations";
    }
    @PostMapping("delete/{id}")
    public String deleteEducation(@PathVariable long id) {
        educationService.deleteEducation(id);
        return "redirect:/education/view";
    }

    @PostMapping("/create")
    public String createEducation(EducationModel educationModel) {
        educationService.saveEducation(educationModel);
        return "redirect:/education/view";
    }


    @PutMapping("/update")
    public String updateEducation(  EducationModel educationModel) {
        educationService.updateEducation(educationModel);
        return "redirect:/education/view";
    }

}
