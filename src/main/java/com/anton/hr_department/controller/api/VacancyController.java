package com.anton.hr_department.controller.api;



import com.anton.hr_department.model.VacancyModel;
import com.anton.hr_department.service.VacancyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/vacancy")
@RequiredArgsConstructor
public class VacancyController {
    private final VacancyService vacancyService;

    @GetMapping("/view")
    public String viewVacancy(Model model) {
        model.addAttribute("vacancies", vacancyService.getAllVacancy());
        return "vacancies";
    }

    @GetMapping("/view/{id}")
    public String getVacancy(@PathVariable long id, Model model) {
        model.addAttribute("vacancy", vacancyService.getVacancy(id));
        model.addAttribute("employees", vacancyService.getVacancy(id).getEmployees());
        model.addAttribute("candidates", vacancyService.getVacancy(id).getCandidates());
        return "vacancy-info";
    }

    @GetMapping("/search")
    public String searchVacancyByJobTitle(@RequestParam(name = "jobTitle", required = false)
                                              String jobTitle, Model model) {
        model.addAttribute("vacancies", vacancyService.findVacancyByTitle(jobTitle));
        return "vacancies";
    }

    @PostMapping("/delete/{id}")
    public String deleteVacancy(@PathVariable long id) {
        vacancyService.deleteVacancy(id);
        return "redirect:/vacancy/view";
    }


    @PostMapping("/create")
    public String createVacancy(VacancyModel vacancy) {
        vacancyService.saveVacancy(vacancy);
        return "redirect:/vacancy/view";
    }

    @PutMapping("/update")
    public String updateVacancy(@RequestBody VacancyModel vacancy) {
        vacancyService.update(vacancy);
        return "redirect:/vacancy/view";
    }

}
