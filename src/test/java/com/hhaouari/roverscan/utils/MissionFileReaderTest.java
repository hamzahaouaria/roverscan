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


    


}
