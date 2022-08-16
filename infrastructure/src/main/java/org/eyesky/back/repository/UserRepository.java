package org.eyesky.back.repository;

import org.eyesky.back.repository.entity.JpaUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<JpaUser, Long> {

    Optional<JpaUser> findByEmail(String userEmail);
}
