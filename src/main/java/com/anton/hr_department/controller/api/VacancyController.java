package com.anton.hr_department.controller.api;

import com.anton.hr_department.dto.VacancyDTO;
import com.anton.hr_department.service.VacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vacancy")
public class VacancyController {
    @Autowired
    VacancyService vacancyService;

    @PostMapping("/create")
    public void createVacancy(@RequestBody VacancyDTO vacancyDTO) {
        vacancyService.saveVacancy(vacancyDTO);
    }

    @GetMapping("/view")
    public List<VacancyDTO> getVacancy() {
        List<VacancyDTO> vacancyDTOS = vacancyService.getAllVacancy();
        return vacancyDTOS;
    }
}
