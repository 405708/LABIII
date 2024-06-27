package com.example.demo.Repositories;

import com.example.demo.Entities.PlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerJpaRepository extends JpaRepository<PlayerEntity, Long> {
    Optional<PlayerEntity> findByUsernameOrEmail(String usuario, String email);
}
