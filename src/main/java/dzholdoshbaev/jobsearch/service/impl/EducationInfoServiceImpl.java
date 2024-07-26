package dzholdoshbaev.jobsearch.service.impl;

import dzholdoshbaev.jobsearch.dao.EducationInfoDao;
import dzholdoshbaev.jobsearch.service.EducationInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@Service
public class EducationInfoServiceImpl implements EducationInfoService {
    private final EducationInfoDao educationInfoDao;
}
