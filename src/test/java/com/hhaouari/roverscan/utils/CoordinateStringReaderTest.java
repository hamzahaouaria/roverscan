package com.hhaouari.roverscan.utils;

import com.hhaouari.roverscan.entities.Plateau;
import com.hhaouari.roverscan.entities.Rover;
import com.hhaouari.roverscan.entities.enums.Direction;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoordinateStringReaderTest {

  private CoordinateStringReader coordinateFileReader;

  @BeforeEach
  void setUp() {
    coordinateFileReader = new CoordinateStringReader();
  }

  @AfterEach
  void tearDown() {
    coordinateFileReader = null;
  }

  @Test
  void readPlateauCoordinate() {
    Plateau plateau = coordinateFileReader.readPlateauCoordinate("5 5");
    Plateau expectedPlateau = new Plateau(5, 5);
    assertEquals(expectedPlateau, plateau);

  }

  @Test
  void readPlateauCoordinateWithVeryBigCoordinates() {
    Plateau plateau = coordinateFileReader.readPlateauCoordinate("5000000000000000 5000000000000000");
    Plateau expectedPlateau = new Plateau(5000000000000000L, 5000000000000000L);
    assertEquals(expectedPlateau, plateau);
  }

  @Test
  void readRoverCoordinate() {
    Rover rover = coordinateFileReader.readRoverCoordinate("1 2 N", "LMLMLMLMM");
    Rover expectedRover = new Rover(1, 2, Direction.N, "LMLMLMLMM");
    assertEquals(expectedRover, rover);
  }
}