package dzholdoshbaev.jobsearch.service;

import dzholdoshbaev.jobsearch.model.ContactsInfo;

import java.util.List;

public interface ContactsInfoService {
    List<ContactsInfo> findByResumeId(Long resumeId);
}
