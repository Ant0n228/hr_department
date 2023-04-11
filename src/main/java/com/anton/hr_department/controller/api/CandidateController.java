package com.anton.hr_department.controller.api;

import com.anton.hr_department.dto.CandidateDTO;
import com.anton.hr_department.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/candidate")
public class CandidateController {
    @Autowired
    CandidateService candidateService;

    @PostMapping("/create")
    public void createCandidate(@RequestBody CandidateDTO candidateDTO) {
        candidateService.saveCandidate(candidateDTO);
    }

    @GetMapping("/view")
    public List<CandidateDTO> getCandidate() {
        List<CandidateDTO> candidateDTOS = candidateService.getAllCandidate();
        return candidateDTOS;
    }

}
