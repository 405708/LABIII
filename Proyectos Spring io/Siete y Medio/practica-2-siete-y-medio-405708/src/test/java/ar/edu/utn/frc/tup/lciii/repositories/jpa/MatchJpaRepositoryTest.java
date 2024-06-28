package ar.edu.utn.frc.tup.lciii.repositories.jpa;

import ar.edu.utn.frc.tup.lciii.entities.MatchEntity;
import ar.edu.utn.frc.tup.lciii.models.MatchStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class MatchJpaRepositoryTest {

    @Autowired
    private MatchJpaRepository matchJpaRepository;

    @Test
    void getAllByPlayerIdAndMatchStatusTest() {
        // TODO: Completar el Test para validar que el metodo
        //  getAllByPlayerIdAndMatchStatus(Long playerId, MatchStatus matchStatus)
        //  de la clase MatchJpaRepository funciona.
        Optional<List<MatchEntity>> matchEntities1 = matchJpaRepository.getAllByPlayerIdAndMatchStatus(1L, MatchStatus.FINISH);
        Optional<List<MatchEntity>> matchEntitiesEmpty1 = Optional.empty();
        assertNotEquals(matchEntitiesEmpty1, matchEntities1);


        Optional<List<MatchEntity>> matchEntities2 = matchJpaRepository.getAllByPlayerIdAndMatchStatus(3L, MatchStatus.PLAYING);
        Optional<List<MatchEntity>> matchEntities3 = matchJpaRepository.getAllByPlayerIdAndMatchStatus(9L, MatchStatus.FINISH);
        assertEquals(matchEntities2.isPresent(), matchEntities3.isPresent());
    }
}