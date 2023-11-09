package com.hhaouari.roverscan.services;

import com.hhaouari.roverscan.entities.Plateau;
import com.hhaouari.roverscan.entities.Rover;
import com.hhaouari.roverscan.entities.enums.Direction;
import com.hhaouari.roverscan.services.impl.PositionHelperImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class PositionHelperTest {

    PositionHelper positionHelper;

    @BeforeEach
    void setUp() {
        positionHelper = new PositionHelperImpl();
    }

    @AfterEach
    void tearDown() {
        positionHelper = null;
    }

    @Test
    void moveForwardWest() {
        Rover rover = new Rover(1, 2, Direction.W, "LMLMLMLMM");
        positionHelper.moveForwardWest(rover);
        assertEquals(0, rover.getX());
    }

    @Test
    void moveForwardEast() {
        Rover rover = new Rover(1, 2, Direction.E, "LMLMLMLMM");
        positionHelper.moveForwardEast(rover, new Plateau(5, 5));
        assertEquals(2, rover.getX());
    }

    @Test
    void moveForwardSouth() {
        Rover rover = new Rover(1, 2, Direction.S, "LMLMLMLMM");
        positionHelper.moveForwardSouth(rover);
        assertEquals(1, rover.getY());
    }

    @Test
    void moveForwardNorth() {
        Rover rover = new Rover(1, 2, Direction.N, "LMLMLMLMM");
        positionHelper.moveForwardNorth(rover, new Plateau(5, 5));
        assertEquals(3, rover.getY());
    }

    @Test
    void moveForwardWestWithInvalidPosition() {
        Rover rover = new Rover(0, 2, Direction.W, "LMLMLMLMM");
        assertFalse(positionHelper.moveForwardWest(rover));
    }

    @Test
    void moveForwardSouthWithInvalidPosition() {
        Rover rover = new Rover(1, 0, Direction.S, "LMLMLMLMM");
        assertFalse(positionHelper.moveForwardSouth(rover));
    }

    @Test
    void moveForwardEastWithInvalidPosition() {
        Rover rover = new Rover(5, 2, Direction.E, "LMLMLMLMM");
        assertFalse(positionHelper.moveForwardEast(rover, new Plateau(5, 5)));
    }

    @Test
    void moveForwardNorthWithInvalidPosition() {
        Rover rover = new Rover(1, 5, Direction.N, "LMLMLMLMM");
        assertFalse(positionHelper.moveForwardNorth(rover, new Plateau(5, 5)));
    }
}