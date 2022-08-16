package org.eyesky.back.repository;

import org.eyesky.back.repository.entity.JpaRole;
import org.eyesky.back.repository.entity.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<JpaRole, Long> {
    JpaRole findByName(RoleEnum name);
}
