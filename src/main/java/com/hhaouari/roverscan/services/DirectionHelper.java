package com.hhaouari.roverscan.services;

import com.hhaouari.roverscan.entities.enums.Direction;

public interface DirectionHelper {
    Direction getNewDirection(Direction currentDirection, char newDirectionInstruction);
}
