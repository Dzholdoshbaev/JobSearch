package dzholdoshbaev.jobsearch.repository;

import dzholdoshbaev.jobsearch.model.Users;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    Users findByEmail(String email);


    @Transactional
    @Modifying
    @Query("""
    UPDATE Users u
    SET u.avatar = :avatar
    WHERE u.email = :email
    """)
    void updateUserPhoto(@Param("email") String email, @Param("avatar") String avatar);


}
