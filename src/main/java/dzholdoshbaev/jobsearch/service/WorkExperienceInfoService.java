package dzholdoshbaev.jobsearch.service;

import dzholdoshbaev.jobsearch.model.WorkExperienceInfo;

public interface WorkExperienceInfoService {
    WorkExperienceInfo getByResumeId(Long resumeId);
}
