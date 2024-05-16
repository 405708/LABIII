package ar.edu.utn.frc.tup.lciii;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.support.ReflectionSupport;

import java.sql.Ref;
import java.util.Optional;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class BattleShipMatchTest {


    @Test
    void testGetYesNoAnswerTrue() {
        // TOD-O: Probar este metodo privado
        String inputTest = "Y";
        BattleShipGame game = new BattleShipGame();
        Optional<Method> metodoProbar = ReflectionSupport.findMethod(BattleShipMatch.class, "getYesNoAnswer");
        metodoProbar.ifPresent(method -> assertTrue((Boolean) ReflectionSupport.invokeMethod(method, game, inputTest)));
    }
    @Test
    void testGetYesNoAnswerFalse() {

        String inputTest = "N";
        BattleShipGame game = new BattleShipGame();
        Optional<Method> metodoProbar = ReflectionSupport.findMethod(BattleShipMatch.class, "getYesNoAnswer");
        metodoProbar.ifPresent(method -> assertFalse((Boolean) ReflectionSupport.invokeMethod(method, game, inputTest)));
    }
    @Test
    void testGetYesNoAnswerNull()
    {
        String inputTest = "Salto";
        BattleShipGame game = new BattleShipGame();
        Optional<Method> metodoProbar = ReflectionSupport.findMethod(BattleShipMatch.class, "getYesNoAnswer");
        metodoProbar.ifPresent(method -> assertNull(ReflectionSupport.invokeMethod(method, game, inputTest)));
    }

}