package dzholdoshbaev.jobsearch.service.impl;

import dzholdoshbaev.jobsearch.model.WorkExperienceInfo;
import dzholdoshbaev.jobsearch.repository.WorkExperienceInfoRepository;
import dzholdoshbaev.jobsearch.service.WorkExperienceInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class WorkExperienceInfoServiceImpl implements WorkExperienceInfoService {

    private final WorkExperienceInfoRepository workExperienceInfoRepository;

    public WorkExperienceInfo getByResumeId(Long resumeId) {
        Optional<WorkExperienceInfo> workExperienceInfo = Optional.ofNullable(workExperienceInfoRepository.findByResumes_Id(resumeId));
        log.info("Retrieved work experience info: {}", workExperienceInfo.isPresent());
        return workExperienceInfo.orElse(null);
    }

}
