package dzholdoshbaev.jobsearch.service.impl;

import dzholdoshbaev.jobsearch.dao.RespondedApplicantsDao;
import dzholdoshbaev.jobsearch.service.RespondedApplicantsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@Service
public class RespondedApplicantsServiceImpl implements RespondedApplicantsService {
    private final RespondedApplicantsDao respondedApplicantsDao;
}
