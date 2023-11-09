package com.hhaouari.roverscan.entities;

import com.hhaouari.roverscan.entities.enums.Direction;
import com.hhaouari.roverscan.entities.enums.Instruction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoverTest {

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

  private static final Instruction[] instructions2 = new Instruction[]{
          Instruction.R,
          Instruction.M,
          Instruction.R,
          Instruction.M,
          Instruction.R,
          Instruction.M,
          Instruction.R,
          Instruction.M,
          Instruction.M};

  @Test
  void testEquals() {
    Rover rover1 = new Rover(1, 2, Direction.N, instructions1);
    Rover rover2 = new Rover(1, 2, Direction.N, instructions1);
    assertEquals(rover1, rover2);
  }

  @Test
  void testEqualsWithDifferentX() {
    Rover rover1 = new Rover(1, 2, Direction.N, instructions1);
    Rover rover2 = new Rover(2, 2, Direction.N, instructions1);
    assertNotEquals(rover1, rover2);
  }

  @Test
  void testEqualsWithDifferentY() {
    Rover rover1 = new Rover(1, 2, Direction.N, instructions1);
    Rover rover2 = new Rover(1, 3, Direction.N, instructions1);
    assertNotEquals(rover1, rover2);
  }

  @Test
  void testEqualsWithDifferentDirection() {
    Rover rover1 = new Rover(1, 2, Direction.N, instructions1);
    Rover rover2 = new Rover(1, 2, Direction.E, instructions1);
    assertNotEquals(rover1, rover2);
  }

  @Test
  void testEqualsWithDifferentInstructions() {
    Rover rover1 = new Rover(1, 2, Direction.N, instructions1);
    Rover rover2 = new Rover(1, 2, Direction.N, instructions2);
    assertEquals(rover1, rover2);
  }

  @Test
  void testHashCode() {
    Rover rover1 = new Rover(1, 2, Direction.N, instructions1);
    Rover rover2 = new Rover(1, 2, Direction.N, instructions1);
    assertEquals(rover1.hashCode(), rover2.hashCode());
  }

  @Test
  void testToString() {
    Rover rover = new Rover(1, 2, Direction.N, instructions1);
    String expectedOutput = "1 2 N";
    assertEquals(expectedOutput, rover.toString());
  }
}