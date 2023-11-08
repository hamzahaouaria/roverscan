package com.hhaouari.roverscan.services;

import com.hhaouari.roverscan.entities.Plateau;
import com.hhaouari.roverscan.entities.Rover;

public interface RoverControlService {
    boolean move(Rover rover, Plateau plateau);

    boolean turnLeft(Rover rover);

    boolean turnRight(Rover rover);

    boolean moveForward(Rover rover, Plateau plateau);

}
