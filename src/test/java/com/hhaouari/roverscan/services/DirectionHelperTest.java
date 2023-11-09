package com.hhaouari.roverscan.services;

import com.hhaouari.roverscan.entities.enums.Direction;
import com.hhaouari.roverscan.exceptions.DirectionInvalidInstructionException;
import com.hhaouari.roverscan.services.impl.DirectionHelperImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class DirectionHelperTest {
    DirectionHelper directionHelper;

    @BeforeEach
    void setUp() {
        directionHelper = new DirectionHelperImpl();
    }

    @AfterEach
    void tearDown() {
        directionHelper = null;
    }

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
    void testGetNewDirectionNToMInvalid() {
        assertThrows(DirectionInvalidInstructionException.class, () -> {
            directionHelper.getNewDirection(Direction.N, 'M');
        });
    }

}
