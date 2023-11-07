package com.hhaouari.roverscan.utils;

import com.hhaouari.roverscan.entities.Mission;
import com.hhaouari.roverscan.entities.Plateau;
import com.hhaouari.roverscan.entities.Rover;
import com.hhaouari.roverscan.entities.enums.Direction;
import com.jayway.jsonpath.internal.Utils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CordinatStringReaderTest {

    private static String FILE_PATH = "src/test/resources/input-case-1.txt.txt";


    @Test
    public void testReadingPlateauCordinate() {
        CordinatStringReader cordinateFileReader = new CordinatStringReader();
        Plateau plateau = cordinateFileReader.readPlateauCordinate("5 5");
        Plateau expectedPlateau = new Plateau(5, 5);

        assert plateau.equals(expectedPlateau);
    }

    @Test
    public void testReadingRoverCordinate() {
        CordinatStringReader cordinateFileReader = new CordinatStringReader();
        Rover rover = cordinateFileReader.readRoverCordinate("1 2 N","LMLMLMLMM");
        Rover expectedRover = new Rover(1, 2, Direction.N, "LMLMLMLMM");
        assert rover.equals(expectedRover);
    }

    @Test
    public void testMission() {
        CordinatFileReader cordinateFileReader = new CordinatFileReader();
        Mission mission = new Mission();
        cordinateFileReader.readMission(FILE_PATH, mission);

        Mission expectedMission = new Mission(new Plateau(5, 5), Utils.toList(
                new Rover(1, 2, Direction.N, "LMLMLMLMM"),
                new Rover(3, 3, Direction.E, "MMRMMRMRRM")
        ));
        assert mission.equals(expectedMission);
    }


    


}
