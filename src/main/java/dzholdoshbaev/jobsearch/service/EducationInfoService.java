package dzholdoshbaev.jobsearch.service;

import dzholdoshbaev.jobsearch.model.EducationInfo;

public interface EducationInfoService {
    EducationInfo findByResumeId(Long resumeId);
}
