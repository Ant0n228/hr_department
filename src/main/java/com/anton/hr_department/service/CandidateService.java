package com.anton.hr_department.service;

import com.anton.hr_department.dto.CandidateDTO;
import com.anton.hr_department.dto.mapper.CandidateDTOMapper;
import com.anton.hr_department.model.CandidateModel;
import com.anton.hr_department.model.mapper.CandidateModelMapper;
import com.anton.hr_department.repository.CandidateModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CandidateService {
    CandidateModelRepository candidateModelRepository;

    @Autowired
    public CandidateService(CandidateModelRepository candidateModelRepository) {
        this.candidateModelRepository = candidateModelRepository;
    }

    public void saveCandidate(CandidateDTO candidateDTO) {
        CandidateModel candidateModel = CandidateModelMapper.mapToModel(candidateDTO);
        candidateModelRepository.save(candidateModel);
    }

    public List<CandidateDTO> getAllCandidate() {
        Iterable<CandidateModel> candidates = candidateModelRepository.findAll();
        List<CandidateDTO> candidateDTOS = new ArrayList<>();

        candidates.forEach(candidate -> {
            candidateDTOS.add(CandidateDTOMapper.mapToDTO(candidate));
        });

        return candidateDTOS;
    }

    public CandidateDTO getCandidate(long idCandidate) {
        Optional<CandidateModel> candidateModel = candidateModelRepository.findById(idCandidate);
        return CandidateDTOMapper.mapToDTO(candidateModel.get());
    }

    public void updateCandidate(CandidateDTO candidateDTO) {
        CandidateModel candidateModel = CandidateModelMapper.mapToModel(candidateDTO);
        candidateModelRepository.save(candidateModel);

    }

    public void deleteCandidate(long idCandidate) {
        Optional<CandidateModel> candidateModel = candidateModelRepository.findById(idCandidate);
        candidateModelRepository.delete(candidateModel.get());
    }
}
