package com.hhaouari.roverscan.utils;

import com.hhaouari.roverscan.constants.TestResources;
import com.hhaouari.roverscan.entities.Mission;
import com.hhaouari.roverscan.entities.Plateau;
import com.hhaouari.roverscan.entities.Rover;
import com.hhaouari.roverscan.entities.enums.Direction;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MissionFileReaderTest {

    private CoordinateStringReader coordinateFileReader;
    private MissionFileReader missionFileReader;

    @BeforeEach
    void setUp() {
        coordinateFileReader = new CoordinateStringReader();
        missionFileReader = new MissionFileReader();
    }

    @AfterEach
    void tearDown() {
        coordinateFileReader = null;
        missionFileReader = null;
    }

    @Test
    void testReadingPlateauCoordinate() {
        Plateau plateau = coordinateFileReader.readPlateauCoordinate("5 5");
        Plateau expectedPlateau = new Plateau(5, 5);

        assertEquals(expectedPlateau, plateau);
    }

    @Test
    void testReadingRoverCoordinate() {
        Rover rover = coordinateFileReader.readRoverCoordinate("1 2 N", "LMLMLMLMM");
        Rover expectedRover = new Rover(1, 2, Direction.N, "LMLMLMLMM");
        assertEquals(expectedRover, rover);
    }

    @Test
    void testMission() {

        Mission mission = missionFileReader.readMission(TestResources.SAMPLE_TEST_CASE_BASIC);
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
        boolean isValid = coordinateFileReader.validateMission(TestResources.SAMPLE_TEST_CASE_BASIC);
        assertTrue(isValid, TestResources.testFilesMessage().get(TestResources.SAMPLE_TEST_CASE_BASIC));
    }

    @Test
    void testValidateMissionWithInvalidFile() {
        MissionFileReader coordinateFileReader = new MissionFileReader();
        boolean isValid = coordinateFileReader.validateMission(TestResources.SRC_TEST_RESOURCES_NOEXIST_TXT);
        assertFalse(isValid, TestResources.testFilesMessage().get(TestResources.SRC_TEST_RESOURCES_NOEXIST_TXT));
    }

    @Test
    void testValidateMissionWithInvalidFile2() {
        MissionFileReader coordinateFileReader = new MissionFileReader();
        boolean isValid = coordinateFileReader.validateMission(TestResources.NOT_VALID_PLATEAU_SIZE);
        assertFalse(isValid, TestResources.testFilesMessage().get(TestResources.NOT_VALID_PLATEAU_SIZE));
    }

    @Test
    void testValidateMissionWithInvalidFile3() {
        MissionFileReader coordinateFileReader = new MissionFileReader();
        boolean isValid = coordinateFileReader.validateMission(TestResources.NOT_VALID_ROVER_POSITION);
        assertFalse(isValid, TestResources.testFilesMessage().get(TestResources.NOT_VALID_ROVER_POSITION));
    }

}
