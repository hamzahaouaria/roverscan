package com.hhaouari.roverscan.services;

import com.hhaouari.roverscan.entities.enums.Direction;
import com.hhaouari.roverscan.entities.enums.Instruction;

public interface DirectionHelper {
    Direction getNewDirection(Direction currentDirection, Instruction newDirectionInstruction);

    Direction getNewDirection(Direction currentDirection, char newDirectionInstruction);
}
