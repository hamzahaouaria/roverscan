package com.hhaouari.roverscan.services;

import com.hhaouari.roverscan.entities.Plateau;
import com.hhaouari.roverscan.entities.Rover;
import com.hhaouari.roverscan.entities.enums.Direction;
import com.hhaouari.roverscan.services.impl.RoverControlServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class RoverControlServiceTest {
    RoverControlService roverControlService;

    @BeforeEach
    void setUp() {
        roverControlService = new RoverControlServiceImpl();
    }

    @AfterEach
    void tearDown() {
        roverControlService = null;
    }

    @Test
    void testCallLeftMethod() {
        String instruction = "L";
        Rover rover = new Rover(1, 2, Direction.N, instruction);
        roverControlService.turnLeft(rover);
        Rover expectedRover = new Rover(1, 2, Direction.W, instruction);
        assertEquals(rover, expectedRover);

    }

    @Test
    void testCallRightMethod() {
        String instruction = "R";
        Rover rover = new Rover(1, 2, Direction.N, instruction);
        roverControlService.turnRight(rover);
        Rover expectedRover = new Rover(1, 2, Direction.E, instruction);
        assertEquals(expectedRover,rover);
    }

    @Test
    void testCallMoveForwardInYMethod() {
        String instruction = "M";
        Rover rover = new Rover(1, 2, Direction.N, instruction);
        Plateau plateau = new Plateau(5, 5);
        roverControlService.move(rover, plateau);
        Rover expectedRover = new Rover(1, 3, Direction.N, null);
        assertEquals(expectedRover,rover);
    }

    @Test
    void testCallMoveForwardInXMethod() {
        String instruction = "M";
        Rover rover = new Rover(1, 2, Direction.E, instruction);
        Plateau plateau = new Plateau(5, 5);
        roverControlService.moveForward(rover, plateau);
        Rover expectedRover = new Rover(2, 2, Direction.E, instruction);
        assertEquals(rover, expectedRover);
    }

    @Test
    void testTurnLeft() {
        Rover rover = new Rover(1, 2, Direction.N, "LMLMLMLMM");
        roverControlService.turnLeft(rover);
        Rover expectedRover = new Rover(1, 2, Direction.W, "LMLMLMLMM");
        assertEquals(expectedRover,rover);

    }

    @Test
    void testTurnRight() {
        Rover rover = new Rover(1, 2, Direction.N, "LMLMLMLMM");
        roverControlService.turnRight(rover);
        Rover expectedRover = new Rover(1, 2, Direction.E, "LMLMLMLMM");
        assertEquals(expectedRover,rover);

    }

    @Test
    void testMoveForward() {
        Rover rover = new Rover(1, 2, Direction.N, "LMLMLMLMM");
        Plateau plateau = new Plateau(5, 5);
        roverControlService.moveForward(rover, plateau);
        Rover expectedRover = new Rover(1, 3, Direction.N, "LMLMLMLMM");
        assertEquals(expectedRover,rover);
    }

    @Test
    void testMove() {
        Rover rover = new Rover(1, 2, Direction.N, "LMLMLMLMM");
        Plateau plateau = new Plateau(5, 5);
        roverControlService.move(rover, plateau);
        Rover expectedRover = new Rover(1, 3, Direction.N, null);
        assertEquals(rover, expectedRover);

    }

    @Test
    void testMove2() {
        Rover rover = new Rover(3, 3, Direction.E, "MMRMMRMRRM");
        Plateau plateau = new Plateau(5, 5);
        roverControlService.move(rover, plateau);
        Rover expectedRover = new Rover(5, 1, Direction.E, null);
        assertEquals(rover, expectedRover);
    }



}
