package com.hhaouari.roverscan.services.impl;

import com.hhaouari.roverscan.entities.Plateau;
import com.hhaouari.roverscan.entities.Rover;
import com.hhaouari.roverscan.services.DirectionHelper;
import com.hhaouari.roverscan.services.RoverControlService;

public class RoverControlServiceImpl implements RoverControlService {

    DirectionHelper directionHelper = new DirectionHelperImpl();

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
        for (int i = 0; i < roverInstructions.length(); i++) {
            char instruction = roverInstructions.charAt(i);
            switch (instruction){
                case 'M':
                    moveForward(rover, plateau);
                    break;
                default:
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
        switch (rover.getDirection()){
            case N:
                if(rover.getY() < plateau.getN()){
                    rover.setY(rover.getY() + 1);
                }
                break;
            case S:
                if(rover.getY() > 0){
                    rover.setY(rover.getY() - 1);
                }
                break;
            case E:
                if(rover.getX() < plateau.getM()){
                    rover.setX(rover.getX() + 1);
                }
                break;
            case W:
                if(rover.getX() > 0){
                    rover.setX(rover.getX() - 1);
                }
                break;
        }
        return true;
    }
}
