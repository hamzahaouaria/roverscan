package com.hhaouari.roverscan.utils;

import com.hhaouari.roverscan.entities.Mission;
import com.hhaouari.roverscan.entities.Plateau;
import com.hhaouari.roverscan.entities.Rover;
import com.hhaouari.roverscan.entities.enums.Direction;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MissionFileReaderTest {

    private static final String FILE_PATH = "src/test/resources/input-case-1.txt";

    @Test
    void testReadingPlateauCoordinate() {
        CoordinateStringReader coordinateFileReader = new CoordinateStringReader();
        Plateau plateau = coordinateFileReader.readPlateauCoordinate("5 5");
        Plateau expectedPlateau = new Plateau(5, 5);

        assertEquals(expectedPlateau, plateau);
    }

    @Test
    void testReadingRoverCoordinate() {
        CoordinateStringReader coordinateFileReader = new CoordinateStringReader();
        Rover rover = coordinateFileReader.readRoverCoordinate("1 2 N", "LMLMLMLMM");
        Rover expectedRover = new Rover(1, 2, Direction.N, "LMLMLMLMM");
        assertEquals(expectedRover, rover);
    }

    @Test
    void testMission() {
        MissionFileReader coordinateFileReader = new MissionFileReader();
        Mission mission = coordinateFileReader.readMission(FILE_PATH);

        Mission expectedMission = new Mission();
        expectedMission.setPlateau(new Plateau(5, 5));
        expectedMission.setRovers(Arrays.asList(
                new Rover(1, 2, Direction.N, "LMLMLMLMM"),
                new Rover(3, 3, Direction.E, "MMRMMRMRRM")));

        assertEquals(expectedMission, mission);
    }

    @Test
    void testValidateMission() {
        MissionFileReader coordinateFileReader = new MissionFileReader();
        boolean isValid = coordinateFileReader.validateMission(FILE_PATH);
        assertTrue(isValid, "Test if a valid mission file is valid");
    }

    @Test
    void testValidateMissionWithInvalidFile() {
        MissionFileReader coordinateFileReader = new MissionFileReader();
        boolean isValid = coordinateFileReader.validateMission("src/test/resources/noexist.txt");
        assertFalse(isValid, "Test if an invalid mission file is invalid for not found.");
    }

    @Test
    void testValidateMissionWithInvalidFile2() {
        MissionFileReader coordinateFileReader = new MissionFileReader();
        boolean isValid = coordinateFileReader.validateMission("src/test/resources/input-case-not-valid-1.txt");
        assertFalse(isValid, "Test if an invalid mission file is invalid for wrong format plateau size.");
    }

    @Test
    void testValidateMissionWithInvalidFile3() {
        MissionFileReader coordinateFileReader = new MissionFileReader();
        boolean isValid = coordinateFileReader.validateMission("src/test/resources/input-case-not-valid-2.txt");
        assertFalse(isValid, "Test if an invalid mission file is invalid for wrong format rover position.");
    }

}
