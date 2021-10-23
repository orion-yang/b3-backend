package com.b3backend.b3backend.repo;

import com.b3backend.b3backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    void deleteById(Long id);

    void deleteUserByFirstName(String firstName);

    Optional<User> findById(Long id);

    Optional<User> findByUserName(String userName);
}

