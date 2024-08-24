package dzholdoshbaev.jobsearch.service.impl;

import dzholdoshbaev.jobsearch.model.ContactTypes;
import dzholdoshbaev.jobsearch.repository.ContactTypesRepository;
import dzholdoshbaev.jobsearch.service.ContactTypesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class ContactTypesServiceImpl implements ContactTypesService {
    private final ContactTypesRepository contactTypesRepository;

    @Override
    public List<ContactTypes> getAllTypes() {

        log.info("ContactTypes list");
        return contactTypesRepository.findAll();
    }
}
