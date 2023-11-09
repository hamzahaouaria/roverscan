package com.hhaouari.roverscan.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class MissionTest {

    @Test
    void testEquals() {
        Mission mission1 = new Mission();
        mission1.setPlateau(new Plateau(5, 5));
        mission1.addRover(new Rover(1, 2, "N", "LMLMLMLMM"));
        mission1.addRover(new Rover(3, 3, "E", "MMRMMRMRRM"));
        mission1.addRover(new Rover(5, 5, "S", "MMRMMRMRRM"));
        Mission mission2 = new Mission();
        mission2.setPlateau(new Plateau(5, 5));
        mission2.addRover(new Rover(1, 2, "N", "LMLMLMLMM"));
        mission2.addRover(new Rover(3, 3, "E", "MMRMMRMRRM"));
        mission2.addRover(new Rover(5, 5, "S", "MMRMMRMRRM"));
        assertEquals(mission1, mission2);
      }

    @Test
    void testEqualsNoEqual() {
        Mission mission1 = new Mission();
        mission1.setPlateau(new Plateau(5, 5));
        mission1.addRover(new Rover(1, 2, "N", "LMLMLMLMM"));
        mission1.addRover(new Rover(3, 3, "E", "MMRMMRMRRM"));
        mission1.addRover(new Rover(5, 5, "S", "MMRMMRMRRM"));
        Mission mission2 = new Mission();
        mission2.setPlateau(new Plateau(5, 5));
        mission2.addRover(new Rover(1, 2, "N", "LMLMLMLMM"));
        mission2.addRover(new Rover(3, 3, "E", "MMRMMRMRRM"));
        mission2.addRover(new Rover(5, 3, "S", "MMRMMRMRRM"));
        assertNotEquals(mission1, mission2);
    }



    @Test
    void testHashCode() {
        Mission mission1 = new Mission();
        mission1.setPlateau(new Plateau(5, 5));
        mission1.addRover(new Rover(1, 2, "N", "LMLMLMLMM"));
        mission1.addRover(new Rover(3, 3, "E", "MMRMMRMRRM"));
        mission1.addRover(new Rover(5, 5, "S", "MMRMMRMRRM"));
        Mission mission2 = new Mission();
        mission2.setPlateau(new Plateau(5, 5));
        mission2.addRover(new Rover(1, 2, "N", "LMLMLMLMM"));
        mission2.addRover(new Rover(3, 3, "E", "MMRMMRMRRM"));
        mission2.addRover(new Rover(5, 5, "S", "MMRMMRMRRM"));
        assertEquals(mission1.hashCode(), mission2.hashCode());

      }

    @Test
    void testToString() {
        Mission mission1 = new Mission();
        mission1.setPlateau(new Plateau(5, 5));
        mission1.addRover(new Rover(1, 2, "N", "LMLMLMLMM"));
        mission1.addRover(new Rover(3, 3, "E", "MMRMMRMRRM"));
        mission1.addRover(new Rover(5, 5, "S", "MMRMMRMRRM"));

        String expectedOutput = "1 2 N\n3 3 E\n5 5 S\n";
        assertEquals(expectedOutput, mission1.toString());

      }
}