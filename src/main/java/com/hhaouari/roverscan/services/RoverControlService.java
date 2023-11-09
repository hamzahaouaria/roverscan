package com.hhaouari.roverscan.services;

import com.hhaouari.roverscan.entities.Plateau;
import com.hhaouari.roverscan.entities.Rover;

public interface RoverControlService {

    /**
     * Move the rover based on all the instructions in the instructions array in respect to the plateau
     * @param rover rover
     * @param plateau plateau
     * @return true if the rover moved forward and false if it didn't
     */
    boolean move(Rover rover, Plateau plateau);

    /**
     * Turn the rover to the left
     * @param rover rover
     * @return true if the turn is done successfully
     */
    boolean turnLeft(Rover rover);

    /**
     * Turn the rover to the right
     * @param rover rover
     * @return true if the turn is done successfully
     */
    boolean turnRight(Rover rover);

    /**
     * Move the rover forward according to the plateau size
     * @param rover rover
     * @param plateau plateau
     * @return true if the rover moved forward and false if it didn't
     */
    boolean moveForward(Rover rover, Plateau plateau);

}
