package com.example.demo.Repositories;

import com.example.demo.Entities.PlayRpsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayRpsJpaRepository extends JpaRepository<PlayRpsEntity, Long> {
}
