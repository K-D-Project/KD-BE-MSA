package com.example.auth;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface KDRoleRepository extends JpaRepository<KDRole, Long> {

    Optional<KDRole> findByType(String type);
}
