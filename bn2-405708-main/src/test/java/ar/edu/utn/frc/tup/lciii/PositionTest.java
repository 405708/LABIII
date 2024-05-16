package ar.edu.utn.frc.tup.lciii;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    @Test
    void testEqualsTrue() {
        // TOD-O: Probar este metodo publico
        Position firstPosition = new Position(1, 2);
        assertTrue(firstPosition.equals(new Position(1, 2)));
    }
    @Test
    void testEqualsFalse()
    {
        Position secondPosition = new Position(1, 6);
        assertFalse(secondPosition.equals(new Position(1, 7)));
    }
}