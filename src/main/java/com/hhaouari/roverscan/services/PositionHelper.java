package com.hhaouari.roverscan.services;

import com.hhaouari.roverscan.entities.Plateau;
import com.hhaouari.roverscan.entities.Rover;

public interface PositionHelper {

    boolean moveForwardWest(Rover rover);

    boolean moveForwardEast(Rover rover, Plateau plateau);

    boolean moveForwardSouth(Rover rover);

    boolean moveForwardNorth(Rover rover, Plateau plateau);
}
