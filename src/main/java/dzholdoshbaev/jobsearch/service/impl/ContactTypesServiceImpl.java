package dzholdoshbaev.jobsearch.service.impl;

import dzholdoshbaev.jobsearch.dao.ContactTypesDao;
import dzholdoshbaev.jobsearch.dto.ContactTypesDto;
import dzholdoshbaev.jobsearch.service.ContactTypesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class ContactTypesServiceImpl implements ContactTypesService {
    private final ContactTypesDao contactTypesDao;

    @Override
    public List<ContactTypesDto> getAllTypes() {
        var list  = contactTypesDao.getAllContactTypes();

        List<ContactTypesDto> contactTypesDtos = list.stream()
                .map(e -> ContactTypesDto.builder()
                        .id(e.getId())
                        .type(e.getType())
                        .build()).toList();

        log.info("ContactTypes list: {}", contactTypesDtos);
        return contactTypesDtos;
    }
}
