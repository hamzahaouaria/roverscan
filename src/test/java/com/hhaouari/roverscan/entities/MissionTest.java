package com.hhaouari.roverscan.entities;

import com.hhaouari.roverscan.entities.enums.Direction;
import com.hhaouari.roverscan.entities.enums.Instruction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
class MissionTest {

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

    @Test
    void testEquals() {
        Mission mission1 = new Mission();
        mission1.setPlateau(new Plateau(5, 5));
        mission1.addRover(new Rover(1, 2, Direction.N, instructions1));
        mission1.addRover(new Rover(3, 3, Direction.E, instructions1));
        mission1.addRover(new Rover(5, 5, Direction.S, instructions1));
        Mission mission2 = new Mission();
        mission2.setPlateau(new Plateau(5, 5));
        mission2.addRover(new Rover(1, 2, Direction.N, instructions1));
        mission2.addRover(new Rover(3, 3, Direction.E, instructions1));
        mission2.addRover(new Rover(5, 5, Direction.S, instructions1));
        assertEquals(mission1, mission2);
      }

    @Test
    void testEqualsNoEqual() {
        Mission mission1 = new Mission();
        mission1.setPlateau(new Plateau(5, 5));
        mission1.addRover(new Rover(1, 2, Direction.N, instructions1));
        mission1.addRover(new Rover(3, 3, Direction.E, instructions1));
        mission1.addRover(new Rover(5, 5, Direction.S, instructions1));
        Mission mission2 = new Mission();
        mission2.setPlateau(new Plateau(5, 5));
        mission2.addRover(new Rover(1, 2, Direction.N, instructions1));
        mission2.addRover(new Rover(3, 3, Direction.E, instructions1));
        mission2.addRover(new Rover(5, 5, Direction.S, instructions1));
        mission2.addRover(new Rover(5, 5, Direction.S, instructions1));
        assertNotEquals(mission1, mission2);
    }



    @Test
    void testHashCode() {
        Mission mission1 = new Mission();
        mission1.setPlateau(new Plateau(5, 5));
        mission1.addRover(new Rover(1, 2, Direction.N, instructions1));
        mission1.addRover(new Rover(3, 3, Direction.E, instructions1));
        mission1.addRover(new Rover(5, 5, Direction.S, instructions1));
        Mission mission2 = new Mission();
        mission2.setPlateau(new Plateau(5, 5));
        mission2.addRover(new Rover(1, 2, Direction.N, instructions1));
        mission2.addRover(new Rover(3, 3, Direction.E, instructions1));
        mission2.addRover(new Rover(5, 5, Direction.S, instructions1));
        assertEquals(mission1.hashCode(), mission2.hashCode());

      }

    @Test
    void testToString() {
        Mission mission1 = new Mission();
        mission1.setPlateau(new Plateau(5, 5));
        mission1.addRover(new Rover(1, 2, Direction.N, instructions1));
        mission1.addRover(new Rover(3, 3, Direction.E, instructions1));
        mission1.addRover(new Rover(5, 5, Direction.S, instructions1));

        String expectedOutput = "1 2 N\n3 3 E\n5 5 S\n";
        assertEquals(expectedOutput, mission1.toString());

      }
}