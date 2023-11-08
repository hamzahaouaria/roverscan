package com.hhaouari.roverscan.services;

import com.hhaouari.roverscan.entities.enums.Direction;
import com.hhaouari.roverscan.services.impl.DirectionHelperImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class DirectionHelperTest {
    DirectionHelper directionHelper = new DirectionHelperImpl();

    @Test
    void testGetNewDirectionNToL() {
        Direction direction = directionHelper.getNewDirection(Direction.N, 'L');
        assertEquals(Direction.W, direction);
    }

    @Test
    void testGetNewDirectionNToR() {
        Direction direction = directionHelper.getNewDirection(Direction.N, 'R');
        assertEquals(Direction.E,direction);
    }

    @Test
    void testGetNewDirectionSToL() {
        Direction direction = directionHelper.getNewDirection(Direction.S, 'L');
        assertEquals(Direction.E,direction);
    }

    @Test
    void testGetNewDirectionSToR() {
        Direction direction = directionHelper.getNewDirection(Direction.S, 'R');
        assertEquals(Direction.W,direction);
    }

    @Test
    void testGetNewDirectionEToL() {
        Direction direction = directionHelper.getNewDirection(Direction.E, 'L');
        assertEquals(Direction.N,direction);
    }

    @Test
    void testGetNewDirectionEToR() {
        Direction direction = directionHelper.getNewDirection(Direction.E, 'R');
        assertEquals(Direction.S,direction);
    }

    @Test
    void testGetNewDirectionWToL() {
        Direction direction = directionHelper.getNewDirection(Direction.W, 'L');
        assertEquals(Direction.S,direction);
    }

    @Test
    void testGetNewDirectionWToR() {
        Direction direction = directionHelper.getNewDirection(Direction.W, 'R');
        assertEquals(Direction.N,direction);
    }

    @Test
    void testGetNewDirectionNToM() {
        assertThrows(RuntimeException.class, () -> {
            directionHelper.getNewDirection(Direction.N, 'M');
        });
    }

}
