package com.hhaouari.roverscan.services.impl;

import com.hhaouari.roverscan.entities.Plateau;
import com.hhaouari.roverscan.entities.Rover;
import com.hhaouari.roverscan.entities.enums.Instruction;
import com.hhaouari.roverscan.services.DirectionCalculatorService;
import com.hhaouari.roverscan.services.PositionCalculatorService;
import com.hhaouari.roverscan.services.RoverControlService;

public class RoverControlServiceImpl implements RoverControlService {

    DirectionCalculatorService directionHelper = new DirectionCalculatorServiceImpl();
    PositionCalculatorService positionCalculatorService = new PositionCalculatorServiceImpl();

    /**
     * Move the rover according to the instructions and the plateau
     * Set the instructions to null after the move is done.
     * 
     * @param rover
     * @param plateau
     * @return true if the move is done successfully
     */
    @Override
    public boolean move(Rover rover, Plateau plateau) {
        Instruction[] roverInstructions = rover.getInstructions();
        if (roverInstructions == null) {
            return false;
        }
        for (Instruction instruction: roverInstructions) {
            if (instruction.equals(Instruction.M)) {
                moveForward(rover, plateau);
            } else {
                rover.setDirection(directionHelper.getNewDirection(rover.getDirection(), instruction));
            }
        }
        return true;
    }

    /**
     * Turn the rover to the left
     * 
     * @param rover
     * @return true if the turn is done successfully
     */
    @Override
    public boolean turnLeft(Rover rover) {
        rover.setDirection(directionHelper.getNewDirection(rover.getDirection(), Instruction.L));
        return true;
    }

    /**
     * Turn the rover to the right
     * 
     * @param rover
     * @return true if the turn is done successfully
     */
    @Override
    public boolean turnRight(Rover rover) {
        rover.setDirection(directionHelper.getNewDirection(rover.getDirection(), Instruction.R));
        return true;
    }

    /**
     * Move the rover forward according to the plateau
     * 
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

    /**
     * Move the rover forward according to the plateau
     *
     * @param rover
     * @param plateau
     * @return true if the move is done successfully, false otherwise
     */
    private boolean moveForwardAccordingToDirection(Rover rover, Plateau plateau) {
        return switch (rover.getDirection()) {
            case N -> positionCalculatorService.moveForwardNorth(rover, plateau);
            case S -> positionCalculatorService.moveForwardSouth(rover);
            case E -> positionCalculatorService.moveForwardEast(rover, plateau);
            case W -> positionCalculatorService.moveForwardWest(rover);
        };
    }

}
