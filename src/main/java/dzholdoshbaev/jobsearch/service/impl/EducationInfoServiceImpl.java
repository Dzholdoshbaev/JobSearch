package dzholdoshbaev.jobsearch.service.impl;


import dzholdoshbaev.jobsearch.model.EducationInfo;
import dzholdoshbaev.jobsearch.repository.EducationInfoRepository;
import dzholdoshbaev.jobsearch.service.EducationInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class EducationInfoServiceImpl implements EducationInfoService {
    private final EducationInfoRepository educationInfoRepository;

    public List<EducationInfo> findByResumeId(Long resumeId) {
        return educationInfoRepository.findByResumes_Id(resumeId);
    }
}
