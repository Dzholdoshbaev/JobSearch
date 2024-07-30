package dzholdoshbaev.jobsearch.service.impl;

import dzholdoshbaev.jobsearch.dao.ContactTypesDao;
import dzholdoshbaev.jobsearch.service.ContactTypesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
@Slf4j
@RequiredArgsConstructor
@Service
public class ContactTypesServiceImpl implements ContactTypesService {
    private final ContactTypesDao contactTypesDao;
}
