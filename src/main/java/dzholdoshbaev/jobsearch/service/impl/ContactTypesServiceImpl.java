package dzholdoshbaev.jobsearch.service.impl;

import dzholdoshbaev.jobsearch.dao.ContactTypesDao;
import dzholdoshbaev.jobsearch.service.ContactTypesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@Service
public class ContactTypesServiceImpl implements ContactTypesService {
    private final ContactTypesDao contactTypesDao;
}
