package com.example.demo.Repositories;

import com.example.demo.Entities.MatchEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MatchJpaRepository extends JpaRepository<MatchEntity, Long> {
    Optional<List<MatchEntity>> getAllByPlayer1Id(Long id);

}
