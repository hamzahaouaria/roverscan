package com.hhaouari.roverscan.entities;

import com.hhaouari.roverscan.entities.enums.Direction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoverTest {

  @Test
  void testEquals() {
    Rover rover1 = new Rover(1, 2, Direction.N, "LMLMLMLMM");
    Rover rover2 = new Rover(1, 2, Direction.N, "LMLMLMLMM");
    assertEquals(rover1, rover2);
  }

  @Test
  void testEqualsWithDifferentX() {
    Rover rover1 = new Rover(1, 2, Direction.N, "LMLMLMLMM");
    Rover rover2 = new Rover(2, 2, Direction.N, "LMLMLMLMM");
    assertNotEquals(rover1, rover2);
  }

  @Test
  void testEqualsWithDifferentY() {
    Rover rover1 = new Rover(1, 2, Direction.N, "LMLMLMLMM");
    Rover rover2 = new Rover(1, 3, Direction.N, "LMLMLMLMM");
    assertNotEquals(rover1, rover2);
  }

  @Test
  void testEqualsWithDifferentDirection() {
    Rover rover1 = new Rover(1, 2, Direction.N, "LMLMLMLMM");
    Rover rover2 = new Rover(1, 2, Direction.E, "LMLMLMLMM");
    assertNotEquals(rover1, rover2);
  }

  @Test
  void testEqualsWithDifferentInstructions() {
    Rover rover1 = new Rover(1, 2, Direction.N, "LMLMLMLMM");
    Rover rover2 = new Rover(1, 2, Direction.N, "LMLMLMLM");
    assertEquals(rover1, rover2);
  }

  @Test
  void testHashCode() {
    Rover rover1 = new Rover(1, 2, Direction.N, "LMLMLMLMM");
    Rover rover2 = new Rover(1, 2, Direction.N, "LMLMLMLMM");
    assertEquals(rover1.hashCode(), rover2.hashCode());
  }

  @Test
  void testToString() {
    Rover rover = new Rover(1, 2, Direction.N, "LMLMLMLMM");
    String expectedOutput = "1 2 N";
    assertEquals(expectedOutput, rover.toString());
  }
}