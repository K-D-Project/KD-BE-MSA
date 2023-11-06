package com.example.auth;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface KDUserRepository extends JpaRepository<KDUser, Long> {

    Optional<KDUser> findByUser_id(String userId);
    boolean existsByEmail(String email);
    boolean existsByUser_id(String userId);

}
