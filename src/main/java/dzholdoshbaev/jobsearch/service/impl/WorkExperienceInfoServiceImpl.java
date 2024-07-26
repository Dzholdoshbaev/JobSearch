package dzholdoshbaev.jobsearch.service.impl;

import dzholdoshbaev.jobsearch.dao.WorkExperienceInfoDao;
import dzholdoshbaev.jobsearch.service.WorkExperienceInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@Service
public class WorkExperienceInfoServiceImpl implements WorkExperienceInfoService {
    private final WorkExperienceInfoDao workExperienceInfoDao;
}
