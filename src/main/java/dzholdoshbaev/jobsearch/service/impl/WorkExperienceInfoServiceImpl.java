package dzholdoshbaev.jobsearch.service.impl;

import dzholdoshbaev.jobsearch.model.WorkExperienceInfo;
import dzholdoshbaev.jobsearch.repository.WorkExperienceInfoRepository;
import dzholdoshbaev.jobsearch.service.WorkExperienceInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@RequiredArgsConstructor
@Service
public class WorkExperienceInfoServiceImpl implements WorkExperienceInfoService {

    private final WorkExperienceInfoRepository workExperienceInfoRepository;

    public List<WorkExperienceInfo> getByResumeId(Long resumeId) {
      return workExperienceInfoRepository.findByResumes_Id(resumeId);
    }

}
