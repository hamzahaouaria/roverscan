package com.hhaouari.roverscan.services;

import com.hhaouari.roverscan.entities.Plateau;
import com.hhaouari.roverscan.entities.Rover;

public interface PositionCalculatorService {

    /**
     * Move the rover forward to the west, if the rover is at the west border of the plateau, it will not move
     * @param rover rover
     * @return true if the rover moved forward and false if it didn't
     */
    boolean moveForwardWest(Rover rover);

    /**
     * Move the rover forward to the east, if the rover is at the east border of the plateau, it will not move
     * @param rover rover
     * @param plateau plateau
     * @return true if the rover moved forward and false if it didn't
     */
    boolean moveForwardEast(Rover rover, Plateau plateau);

    /**
     * Move the rover forward to the south, if the rover is at the south border of the plateau, it will not move
     * @param rover rover
     * @return true if the rover moved forward and false if it didn't
     */
    boolean moveForwardSouth(Rover rover);

    /**
     * Move the rover forward to the north, if the rover is at the north border of the plateau, it will not move
     * @param rover rover
     * @param plateau plateau
     * @return true if the rover moved forward and false if it didn't
     */
    boolean moveForwardNorth(Rover rover, Plateau plateau);
}
