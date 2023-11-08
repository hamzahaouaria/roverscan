package com.hhaouari.roverscan.utils;

import com.hhaouari.roverscan.entities.Plateau;
import com.hhaouari.roverscan.entities.Rover;
import com.hhaouari.roverscan.entities.enums.Direction;

public class CoordinateStringReader {

    public Plateau readPlateauCoordinate(String s) {
        String[] coordinates = s.split(" ");
        return getPlateauFromCoordinates(coordinates);
    }

    public Rover readRoverCoordinate(String position, String instructions) {
        String[] coordinates = position.split(" ");
        return getRoverFromCoordinates(instructions, coordinates);
    }

    private static Plateau getPlateauFromCoordinates(String[] coordinates) {
        return new Plateau(Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1]));
    }

    private static Rover getRoverFromCoordinates(String instructions, String[] coordinates) {
        Rover rover = new Rover();
        rover.setX(Integer.parseInt(coordinates[0]));
        rover.setY(Integer.parseInt(coordinates[1]));
        rover.setDirection(Direction.valueOf(coordinates[2]));
        rover.setInstructions(instructions);
        return rover;
    }
}
