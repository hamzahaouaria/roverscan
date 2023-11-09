package com.hhaouari.roverscan.services.impl;

import com.hhaouari.roverscan.entities.Plateau;
import com.hhaouari.roverscan.entities.Rover;
import com.hhaouari.roverscan.services.PositionCalculatorService;

public class PositionCalculatorServiceImpl implements PositionCalculatorService {

    /**
     * Move the rover forward to the west, if the rover is at the west border of the plateau, it will not move
     * @param rover rover
     * @return true if the rover moved forward and false if it didn't
     */
    @Override
    public boolean moveForwardWest(Rover rover) {
        if (rover.getX() > 0) {
            rover.setX(rover.getX() - 1);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Move the rover forward to the east, if the rover is at the east border of the plateau, it will not move
     * @param rover rover
     * @param plateau plateau
     * @return true if the rover moved forward and false if it didn't
     */
    @Override
    public boolean moveForwardEast(Rover rover, Plateau plateau) {
        if (rover.getX() < plateau.getWidth()) {
            rover.setX(rover.getX() + 1);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Move the rover forward to the south, if the rover is at the south border of the plateau, it will not move
     * @param rover rover
     * @return true if the rover moved forward and false if it didn't
     */
    @Override
    public boolean moveForwardSouth(Rover rover) {
        if (rover.getY() > 0) {
            rover.setY(rover.getY() - 1);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Move the rover forward to the north, if the rover is at the north border of the plateau, it will not move
     * @param rover rover
     * @param plateau plateau
     * @return true if the rover moved forward and false if it didn't
     */
    @Override
    public boolean moveForwardNorth(Rover rover, Plateau plateau) {
        if (rover.getY() < plateau.getWidth()) {
            rover.setY(rover.getY() + 1);
            return true;
        } else {
            return false;
        }
    }

}
