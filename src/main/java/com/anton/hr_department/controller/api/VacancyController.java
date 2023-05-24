package com.anton.hr_department.controller.api;



import com.anton.hr_department.model.VacancyModel;
import com.anton.hr_department.service.VacancyService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/vacancy")
@RequiredArgsConstructor
@PreAuthorize("hasAnyAuthority('ROLE_CHIEF', 'ROLE_HR_SPECIALIST', 'ROLE_USER')")
public class VacancyController {
    private final VacancyService vacancyService;
    private final AppController appController;

    @GetMapping("/view")
    public String viewVacancy(Model model) {
        model.addAttribute("vacancies", vacancyService.getAllVacancys());
        model.addAttribute("user", appController.getUser());
        return "vacancies";
    }

    @GetMapping("/view/{id}")
    public String getVacancy(@PathVariable long id, Model model) {
        model.addAttribute("vacancy", vacancyService.getVacancy(id));
        model.addAttribute("employees", vacancyService.getVacancy(id).getEmployees());
        model.addAttribute("candidates", vacancyService.getVacancy(id).getCandidates());
        model.addAttribute("user", appController.getUser());
        return "vacancy-info";
    }

    @GetMapping("/search")
    public String searchVacancyByJobTitle(@RequestParam(name = "jobTitle", required = false)
                                              String jobTitle, Model model) {
        model.addAttribute("vacancies", vacancyService.findVacancyByTitle(jobTitle));
        model.addAttribute("user", appController.getUser());
        return "vacancies";
    }

    @PostMapping("/delete/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_CHIEF', 'ROLE_HR_SPECIALIST')")
    public String deleteVacancy(@PathVariable long id) {
        vacancyService.deleteVacancy(id);
        return "redirect:/vacancy/view";
    }


    @PostMapping("/create")
    @PreAuthorize("hasAnyAuthority('ROLE_CHIEF', 'ROLE_HR_SPECIALIST')")
    public String createVacancy(VacancyModel vacancy) {
        vacancyService.saveVacancy(vacancy);
        return "redirect:/vacancy/view";
    }

    @PutMapping("/update")
    @PreAuthorize("hasAnyAuthority('ROLE_CHIEF', 'ROLE_HR_SPECIALIST')")
    public String updateVacancy(@RequestBody VacancyModel vacancy) {
        vacancyService.update(vacancy);
        return "redirect:/vacancy/view";
    }

}
