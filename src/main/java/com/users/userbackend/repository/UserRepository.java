package com.users.userbackend.repository;

import com.users.userbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findByisbn(String isbn);

    @Transactional
    @Modifying
    void deleteByIsbn(String isbn);

}
