package com.anton.hr_department.service;

import com.anton.hr_department.dto.CandidateDTO;
import com.anton.hr_department.dto.mapper.CandidateDTOMapper;
import com.anton.hr_department.model.CandidateModel;
import com.anton.hr_department.model.VacancyModel;
import com.anton.hr_department.repository.CandidateModelRepository;
import com.anton.hr_department.repository.EducationModelRepository;
import com.anton.hr_department.repository.VacancyModelRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CandidateService {
    private final CandidateModelRepository candidateModelRepository;
    private final VacancyModelRepository vacancyModelRepository;
    private final EducationModelRepository educationModelRepository;

    private final CandidateDTOMapper candidateDTOMapper;

    public void saveCandidate(CandidateDTO candidateDTO, Long idVacancy) {
        CandidateModel candidateModel = candidateDTOMapper.mapToModel(candidateDTO);
        VacancyModel vacancyModel = vacancyModelRepository.findById(idVacancy).orElse(null);
        candidateModel.setVacancy(vacancyModel);
        educationModelRepository.save(candidateModel.getEducation());
        candidateModelRepository.save(candidateModel);
    }

    public List<CandidateDTO> getAllCandidates() {
        Iterable<CandidateModel> candidates = candidateModelRepository.findAll();
        List<CandidateDTO> candidateDTOS = new ArrayList<>();

        candidates.forEach(candidate -> candidateDTOS.add(candidateDTOMapper.mapToDTO(candidate)));
        return candidateDTOS;
    }

    public CandidateDTO getCandidate(long idCandidate) {
        Optional<CandidateModel> candidateModel = candidateModelRepository.findById(idCandidate);
        return candidateModel.map(candidateDTOMapper::mapToDTO).orElse(null);
    }

    public void updateCandidate(CandidateDTO candidateDTO) {
        CandidateModel candidateModel = candidateDTOMapper.mapToModel(candidateDTO);
        candidateModelRepository.save(candidateModel);

    }

    public void deleteCandidate(long idCandidate) {
        Optional<CandidateModel> candidateModel = candidateModelRepository.findById(idCandidate);
        candidateModel.ifPresent(candidateModelRepository::delete);
    }

    public List<CandidateDTO> findCandidateByFio(String fio) {
        List<CandidateModel> candidateModels = fio != null ?
                candidateModelRepository.findCandidateModelByFio(fio) :
                candidateModelRepository.findAll();

        List<CandidateDTO> candidateDTOS = new ArrayList<>();
        candidateModels.forEach(candidateModel -> candidateDTOS.add(candidateDTOMapper.mapToDTO(candidateModel)));
        return candidateDTOS;
    }
}
