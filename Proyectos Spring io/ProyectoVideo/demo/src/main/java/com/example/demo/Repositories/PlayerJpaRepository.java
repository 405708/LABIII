package com.example.demo.Repositories;

import com.example.demo.Entities.PlayerEntity;
import com.example.demo.Models.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlayerJpaRepository extends JpaRepository<PlayerEntity, Long> {
    Optional<PlayerEntity> findByUsernameOrEmail(String usuario, String email);
    Optional<PlayerEntity> findByUsernameAndPassword(String user, String password);
    Optional<PlayerEntity> findByEmailAndPassword(String email, String password);

    //(A OR B) AND C
    @Query("SELECT p FROM PlayerEntity p" +
            " WHERE (p.username LIKE :identity OR p.email LIKE :identity)" +
            " AND p.password LIKE :password")
    Optional<PlayerEntity> findByUsernameOrEmailAndPassword(@Param("identity") String identity, @Param("password") String password);
}

