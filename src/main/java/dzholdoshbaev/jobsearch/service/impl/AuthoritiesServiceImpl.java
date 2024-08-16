package dzholdoshbaev.jobsearch.service.impl;

import dzholdoshbaev.jobsearch.dao.AuthoritiesDao;
import dzholdoshbaev.jobsearch.dto.AuthoritiesDto;
import dzholdoshbaev.jobsearch.model.Authorities;
import dzholdoshbaev.jobsearch.service.AuthoritiesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class AuthoritiesServiceImpl implements AuthoritiesService {
    private final AuthoritiesDao authoritiesDao;


    @Override
    public List<AuthoritiesDto> getAllAuthorities() {
       var list = authoritiesDao.findAll();

       List<AuthoritiesDto> authoritiesDtos = list.stream()
               .map(a -> AuthoritiesDto.builder()
                       .id(a.getId())
                       .authority(a.getAuthority())
                       .build()).toList();
       log.info("Authorities: {}", authoritiesDtos);
       return authoritiesDtos;
    }
}
