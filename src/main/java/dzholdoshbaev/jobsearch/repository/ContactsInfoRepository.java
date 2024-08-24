package dzholdoshbaev.jobsearch.repository;

import dzholdoshbaev.jobsearch.model.ContactsInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactsInfoRepository extends JpaRepository<ContactsInfo, Long> {
}
