package com.example.demo.Repositories;

import com.example.demo.Entities.PlayerEntity;
import com.example.demo.Models.Player;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PlayerJpaRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PlayerJpaRepository playerJpaRepository;

    @Test
    void findByUsernameOrEmailTest() {
        PlayerEntity playerEntity = new PlayerEntity();
        playerEntity.setEmail("email@email.com");
        playerEntity.setUsername("martin");
        playerEntity.setPassword("Password03#");

        entityManager.persist(playerEntity);
        entityManager.flush();

        Optional<PlayerEntity> result = playerJpaRepository.findByUsernameOrEmail("martin","email@email.com");
        assertEquals("martin", result.get().getUsername());

    }
}