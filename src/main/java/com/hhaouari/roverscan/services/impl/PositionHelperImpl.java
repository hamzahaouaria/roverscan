package com.hhaouari.roverscan.services.impl;

import com.hhaouari.roverscan.entities.Plateau;
import com.hhaouari.roverscan.entities.Rover;
import com.hhaouari.roverscan.services.PositionHelper;

public class PositionHelperImpl implements PositionHelper {
    @Override
    public boolean moveForwardWest(Rover rover) {
        if (rover.getX() > 0) {
            rover.setX(rover.getX() - 1);
            return true;
        }  else {
            return false;
        }
    }

    @Override
    public boolean moveForwardEast(Rover rover, Plateau plateau) {
        if (rover.getX() < plateau.getWidth()) {
            rover.setX(rover.getX() + 1);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean moveForwardSouth(Rover rover) {
        if (rover.getY() > 0) {
            rover.setY(rover.getY() - 1);
            return true;
        } else {
            return false;
        }
    }

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
