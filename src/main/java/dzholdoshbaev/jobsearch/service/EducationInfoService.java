package dzholdoshbaev.jobsearch.service;

import dzholdoshbaev.jobsearch.model.EducationInfo;

import java.util.List;

public interface EducationInfoService {
    List<EducationInfo> findByResumeId(Long resumeId);
}
