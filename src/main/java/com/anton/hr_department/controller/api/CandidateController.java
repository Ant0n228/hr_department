package com.anton.hr_department.controller.api;

import com.anton.hr_department.dto.CandidateDTO;
import com.anton.hr_department.service.CandidateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/candidate")
@RequiredArgsConstructor
public class CandidateController {
    private final CandidateService candidateService;
    @GetMapping("/view")
    public String getCandidate(Model model) {
        model.addAttribute("candidates", candidateService.getAllCandidate());
        return "candidates";
    }

    @GetMapping("/view/{id}")
    public String getCandidate(@PathVariable long id, Model model) {
        model.addAttribute("candidate", candidateService.getCandidate(id));
        return "candidate-info";
    }

    @PostMapping("/create")
    public String createCandidate(CandidateDTO candidateDTO) {
        candidateService.saveCandidate(candidateDTO);
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
        return "candidates";
    }

}
