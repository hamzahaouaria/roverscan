package com.hhaouari.roverscan.utils;

import com.hhaouari.roverscan.entities.Mission;
import com.hhaouari.roverscan.entities.Plateau;
import com.hhaouari.roverscan.entities.Rover;
import com.hhaouari.roverscan.entities.enums.Direction;
import com.jayway.jsonpath.internal.Utils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class MissionFileReaderTest {

    private static String FILE_PATH = "src/test/resources/input-case-1.txt";


    @Test
    public void testReadingPlateauCordinate() {
        CordinateStringReader cordinateFileReader = new CordinateStringReader();
        Plateau plateau = cordinateFileReader.readPlateauCordinate("5 5");
        Plateau expectedPlateau = new Plateau(5, 5);

        assert plateau.equals(expectedPlateau);
    }

    @Test
    public void testReadingRoverCordinate() {
        CordinateStringReader cordinateFileReader = new CordinateStringReader();
        Rover rover = cordinateFileReader.readRoverCordinate("1 2 N","LMLMLMLMM");
        Rover expectedRover = new Rover(1, 2, Direction.N, "LMLMLMLMM");
        assert rover.equals(expectedRover);
    }

    @Test
    public void testMission() {
        MissionFileReader cordinateFileReader = new MissionFileReader();
        Mission mission = cordinateFileReader.readMission(FILE_PATH);


        Mission expectedMission = new Mission();
        expectedMission.setPlateau(new Plateau(5, 5));
        expectedMission.setRovers(Arrays.asList(
                new Rover(1, 2, Direction.N, "LMLMLMLMM"),
                new Rover(3, 3, Direction.E, "MMRMMRMRRM")
        ));

        assert mission.equals(expectedMission);
    }

    @Test
    public void testValidateMission() {
        MissionFileReader cordinateFileReader = new MissionFileReader();
        boolean isValid = cordinateFileReader.validateMission(FILE_PATH);
        assertEquals(isValid, true, "Test if a valid mission file is valid");
    }

    @Test
    public void testValidateMissionWithInvalidFile() {
        MissionFileReader cordinateFileReader = new MissionFileReader();
        boolean isValid = cordinateFileReader.validateMission("src/test/resources/noexist.txt");
        assertEquals(isValid, false, "Test if an invalid mission file is invalid for not found.");
    }

    @Test
    public void testValidateMissionWithInvalidFile2() {
        MissionFileReader cordinateFileReader = new MissionFileReader();
        boolean isValid = cordinateFileReader.validateMission("src/test/resources/input-case-not-valid-1.txt");
        assertEquals(isValid, false, "Test if an invalid mission file is invalid for wrong format plateau size.");
    }

    @Test
    public void testValidateMissionWithInvalidFile3() {
        MissionFileReader cordinateFileReader = new MissionFileReader();
        boolean isValid = cordinateFileReader.validateMission("src/test/resources/input-case-not-valid-2.txt");
        assertEquals(isValid, false, "Test if an invalid mission file is invalid for wrong format rover position.");
    }


    


}
