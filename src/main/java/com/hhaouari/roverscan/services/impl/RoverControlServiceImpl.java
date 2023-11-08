package com.hhaouari.roverscan.services.impl;

import com.hhaouari.roverscan.entities.Plateau;
import com.hhaouari.roverscan.entities.Rover;
import com.hhaouari.roverscan.services.DirectionHelper;
import com.hhaouari.roverscan.services.PositionHelper;
import com.hhaouari.roverscan.services.RoverControlService;

public class RoverControlServiceImpl implements RoverControlService {

    DirectionHelper directionHelper = new DirectionHelperImpl();
    PositionHelper positionHelper = new PositionHelperImpl();

    /**
     * Move the rover according to the instructions and the plateau
     * Set the instructions to null after the move is done.
     * @param rover
     * @param plateau
     * @return true if the move is done successfully
     */
    @Override
    public boolean move(Rover rover, Plateau plateau) {
        String roverInstructions = rover.getInstructions();
        if (roverInstructions == null) {
            return false;
        }
        for (int i = 0; i < roverInstructions.length(); i++) {
            char instruction = roverInstructions.charAt(i);
            if (instruction == 'M') {
                moveForward(rover, plateau);
            } else {
                rover.setDirection(directionHelper.getNewDirection(rover.getDirection(), instruction));
            }
        }
        rover.setInstructions(null);
        return true;
    }

    /**
     * Turn the rover to the left
     * @param rover
     * @return true if the turn is done successfully
     */
    @Override
    public boolean turnLeft(Rover rover) {
        rover.setDirection(directionHelper.getNewDirection(rover.getDirection(), 'L'));
        return true;
    }

    /**
     * Turn the rover to the right
     * @param rover
     * @return true if the turn is done successfully
     */
    @Override
    public boolean turnRight(Rover rover) {
        rover.setDirection(directionHelper.getNewDirection(rover.getDirection(), 'R'));
        return true;
    }

    /**
     * Move the rover forward according to the plateau
     * @param rover
     * @param plateau
     * @return true if the move is done successfully
     */
    @Override
    public boolean moveForward(Rover rover, Plateau plateau) {

        boolean isMoveDone;

        isMoveDone = moveForwardAccordingToDirection(rover, plateau);
        return isMoveDone;
    }

    private boolean moveForwardAccordingToDirection(Rover rover, Plateau plateau) {
        return switch (rover.getDirection()) {
            case N -> positionHelper.moveForwardNorth(rover, plateau);
            case S -> positionHelper.moveForwardSouth(rover);
            case E -> positionHelper.moveForwardEast(rover, plateau);
            case W -> positionHelper.moveForwardWest(rover);
        };
    }

}
