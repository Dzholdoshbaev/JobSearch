package dzholdoshbaev.jobsearch.service;

import dzholdoshbaev.jobsearch.model.WorkExperienceInfo;

import java.util.List;

public interface WorkExperienceInfoService {
    List<WorkExperienceInfo> getByResumeId(Long resumeId);
}
