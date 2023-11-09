package com.hhaouari.roverscan.utils;

import com.hhaouari.roverscan.entities.Plateau;
import com.hhaouari.roverscan.entities.Rover;
import com.hhaouari.roverscan.entities.enums.Direction;

public class CoordinateStringReader {

    /**
     * @param coordinates String array containing the coordinates of the plateau
     * @return Plateau object
     */
    private static Plateau getPlateauFromCoordinates(String[] coordinates) {
        return new Plateau(Long.parseLong(coordinates[0]), Long.parseLong(coordinates[1]));
    }

    /**
     * @param instructions String containing the instructions of the rover
     * @param coordinates  String array containing the coordinates of the rover
     * @return Rover object
     */
    private static Rover getRoverFromCoordinates(String instructions, String[] coordinates) {
        Rover rover = new Rover();
        rover.setX(Long.parseLong(coordinates[0]));
        rover.setY(Long.parseLong(coordinates[1]));
        rover.setDirection(Direction.valueOf(coordinates[2]));
        rover.setInstructions(instructions);
        return rover;
    }

    /**
     * @param line line String containing the coordinates of the plateau
     * @return Plateau object
     */
    public Plateau readPlateauCoordinate(String line) {
        String[] coordinates = line.split(" ");
        return getPlateauFromCoordinates(coordinates);
    }

    /**
     * @param positionLine     String containing the coordinates of the rover
     * @param instructionsLine String containing the instructions of the rover
     * @return Rover object
     */
    public Rover readRoverCoordinate(String positionLine, String instructionsLine) {
        String[] coordinates = positionLine.split(" ");
        return getRoverFromCoordinates(instructionsLine, coordinates);
    }
}
