package com.hhaouari.roverscan.services;

import com.hhaouari.roverscan.entities.Plateau;
import com.hhaouari.roverscan.entities.Rover;
import com.hhaouari.roverscan.entities.enums.Direction;
import com.hhaouari.roverscan.entities.enums.Instruction;
import com.hhaouari.roverscan.services.impl.PositionCalculatorServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositionCalculatorServiceTest {

    PositionCalculatorService positionCalculatorService;

    private static final Instruction[] instructions1 = new Instruction[]{
            Instruction.L,
            Instruction.M,
            Instruction.L,
            Instruction.M,
            Instruction.L,
            Instruction.M,
            Instruction.L,
            Instruction.M,
            Instruction.M};

    @BeforeEach
    void setUp() {
        positionCalculatorService = new PositionCalculatorServiceImpl();
    }

    @AfterEach
    void tearDown() {
        positionCalculatorService = null;
    }

    @Test
    void moveForwardWest() {
        Rover rover = new Rover(1, 2, Direction.W, instructions1);
        positionCalculatorService.moveForwardWest(rover);
        assertEquals(0, rover.getX());
    }

    @Test
    void moveForwardEast() {
        Rover rover = new Rover(1, 2, Direction.E, instructions1);
        positionCalculatorService.moveForwardEast(rover, new Plateau(5, 5));
        assertEquals(2, rover.getX());
    }

    @Test
    void moveForwardSouth() {
        Rover rover = new Rover(1, 2, Direction.S, instructions1);
        positionCalculatorService.moveForwardSouth(rover);
        assertEquals(1, rover.getY());
    }

    @Test
    void moveForwardNorth() {
        Rover rover = new Rover(1, 2, Direction.N, instructions1);
        positionCalculatorService.moveForwardNorth(rover, new Plateau(5, 5));
        assertEquals(3, rover.getY());
    }

    @Test
    void moveForwardWestWithInvalidPosition() {
        Rover rover = new Rover(0, 2, Direction.W, instructions1);
        assertFalse(positionCalculatorService.moveForwardWest(rover));
    }

    @Test
    void moveForwardSouthWithInvalidPosition() {
        Rover rover = new Rover(1, 0, Direction.S, instructions1);
        assertFalse(positionCalculatorService.moveForwardSouth(rover));
    }

    @Test
    void moveForwardEastWithInvalidPosition() {
        Rover rover = new Rover(5, 2, Direction.E, instructions1);
        assertFalse(positionCalculatorService.moveForwardEast(rover, new Plateau(5, 5)));
    }

    @Test
    void moveForwardNorthWithInvalidPosition() {
        Rover rover = new Rover(1, 5, Direction.N, instructions1);
        assertFalse(positionCalculatorService.moveForwardNorth(rover, new Plateau(5, 5)));
    }
}