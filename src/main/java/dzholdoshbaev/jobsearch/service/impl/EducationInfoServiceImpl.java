package dzholdoshbaev.jobsearch.service.impl;


import dzholdoshbaev.jobsearch.model.EducationInfo;
import dzholdoshbaev.jobsearch.repository.EducationInfoRepository;
import dzholdoshbaev.jobsearch.service.EducationInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
@Slf4j
@RequiredArgsConstructor
@Service
public class EducationInfoServiceImpl implements EducationInfoService {
    private final EducationInfoRepository educationInfoRepository;

    public EducationInfo findByResumeId(Long resumeId) {
        EducationInfo educationInfo = educationInfoRepository.findByResumes_Id(resumeId);
        log.info("Found education info for resumeId: {}", resumeId);
        return educationInfo;
    }
}
