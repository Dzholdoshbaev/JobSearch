package dzholdoshbaev.jobsearch.service.impl;

import dzholdoshbaev.jobsearch.dao.WorkExperienceInfoDao;
import dzholdoshbaev.jobsearch.service.WorkExperienceInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
@Slf4j
@RequiredArgsConstructor
@Service
public class WorkExperienceInfoServiceImpl implements WorkExperienceInfoService {
    private final WorkExperienceInfoDao workExperienceInfoDao;
}
