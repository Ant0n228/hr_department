package com.anton.hr_department.controller.api;

import com.anton.hr_department.dto.VacancyDTO;
import com.anton.hr_department.dto.VacancyWithRequirementsDTO;
import com.anton.hr_department.service.VacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vacancy")
public class VacancyController {
    VacancyService vacancyService;

    @Autowired
    public VacancyController(VacancyService vacancyService) {
        this.vacancyService = vacancyService;
    }

    @PostMapping("/create")
    public void createVacancy(@RequestBody VacancyDTO vacancyDTO) {
        vacancyService.saveVacancy(vacancyDTO);
    }

    @PostMapping("create/new")
    public void createVacancyWithRequirements(@RequestBody VacancyWithRequirementsDTO vacancyWithRequirementsDTO) {
        vacancyService.saveVacancyWithRequirement(vacancyWithRequirementsDTO);
    }
    @GetMapping("/view")
    public List<VacancyDTO> getVacancy() {
        return vacancyService.getAllVacancy();
    }

    @GetMapping("/view/{id}")
    public VacancyDTO getVacancy(@PathVariable long id) {
        return vacancyService.getVacancy(id);
    }

    @GetMapping("/view/new/{id}")
    public VacancyWithRequirementsDTO getVacancyWithRequirements(@PathVariable long id) {
        return vacancyService.getVacancyWithRequirement(id);
    }


    @PutMapping("/update")
    public void updateVacancy(@RequestBody VacancyDTO vacancyDTO) {
        vacancyService.updateVacancy(vacancyDTO);
    }

    @DeleteMapping("delete/{id}")
    public void deleteVacancy(@PathVariable long id) {
        vacancyService.deleteVacancy(id);
    }
}
