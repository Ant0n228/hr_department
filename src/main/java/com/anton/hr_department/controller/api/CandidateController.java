package com.anton.hr_department.controller.api;

import com.anton.hr_department.dto.CandidateDTO;
import com.anton.hr_department.service.CandidateService;
import com.anton.hr_department.service.VacancyService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/candidate")
@RequiredArgsConstructor
@PreAuthorize("hasAnyAuthority('ROLE_CHIEF', 'ROLE_HR_SPECIALIST', 'ROLE_DEPARTMENT_ENGINEER')")
public class CandidateController {
    private final CandidateService candidateService;
    private final VacancyService vacancyService;
    private final AppController appController;

    @GetMapping("/view")
    public String getCandidate(Model model) {
        model.addAttribute("candidates", candidateService.getAllCandidates());
        model.addAttribute("vacancies", vacancyService.getAllVacancys());
        model.addAttribute("user", appController.getUser());
        return "candidates";
    }

    @GetMapping("/view/{id}")
    public String getCandidate(@PathVariable long id, Model model) {
        model.addAttribute("candidate", candidateService.getCandidate(id));
        model.addAttribute("user", appController.getUser());
        return "candidate-info";
    }

    @PostMapping("/create")
    public String createCandidate(CandidateDTO candidateDTO, @RequestParam Long idVacancy) {
        candidateService.saveCandidate(candidateDTO, idVacancy);
        return "redirect:/candidate/view";
    }


    @PutMapping("/update")
    public String updateCandidate(CandidateDTO candidateDTO) {
        candidateService.updateCandidate(candidateDTO);
        return "redirect:/candidate/view";
    }

    @PostMapping("/delete/{id}")
    public String deleteCandidate(@PathVariable long id) {
        candidateService.deleteCandidate(id);
        return "redirect:/candidate/view";
    }

    @GetMapping("/search")
    public String searchByFio(@RequestParam(name = "fio", required = false) String fio,
                              Model model) {
        model.addAttribute("candidates", candidateService.findCandidateByFio(fio));
        model.addAttribute("user", appController.getUser());
        return "candidates";
    }

}
