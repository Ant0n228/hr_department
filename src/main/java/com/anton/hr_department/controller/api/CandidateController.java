package com.anton.hr_department.controller.api;

import com.anton.hr_department.dto.CandidateDTO;
import com.anton.hr_department.service.CandidateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/candidate")
@RequiredArgsConstructor
public class CandidateController {
    private final CandidateService candidateService;

    @PostMapping("/create")
    public void createCandidate(@RequestBody CandidateDTO candidateDTO) {
        candidateService.saveCandidate(candidateDTO);
    }

    @GetMapping("/view")
    public List<CandidateDTO> getCandidate() {
        return candidateService.getAllCandidate();
    }

    @GetMapping("/view/{id}")
    public CandidateDTO getCandidate(@PathVariable long id) {
        return candidateService.getCandidate(id);
    }

    @PutMapping("/update")
    public void updateCandidate(@RequestBody CandidateDTO candidateDTO) {
        candidateService.updateCandidate(candidateDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCandidate(@PathVariable long id) {
        candidateService.deleteCandidate(id);
    }

}
