package com.hhaouari.roverscan.utils;

import com.hhaouari.roverscan.entities.Plateau;
import com.hhaouari.roverscan.entities.Rover;
import com.hhaouari.roverscan.entities.enums.Direction;

public class CordinateStringReader {

    public Plateau readPlateauCordinate(String s) {
        String[] cordinates = s.split(" ");
        return new Plateau(Integer.parseInt(cordinates[0]), Integer.parseInt(cordinates[1]));
    }

    public Rover readRoverCordinate(String s, String instructions) {
        String[] cordinates = s.split(" ");
        Rover rover = new Rover();
        rover.setX(Integer.parseInt(cordinates[0]));
        rover.setY(Integer.parseInt(cordinates[1]));
        rover.setDirection(Direction.valueOf(cordinates[2]));
        rover.setInstructions(instructions);
        return rover;
    }
}
