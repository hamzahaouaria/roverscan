package com.hhaouari.roverscan.services;

import com.hhaouari.roverscan.entities.enums.Direction;
import com.hhaouari.roverscan.entities.enums.Instruction;

public interface DirectionCalculatorService {

    /**
     * @param currentDirection current direction
     * @param newDirectionInstruction new direction instruction
     * @return new direction
     */
    Direction getNewDirection(Direction currentDirection, Instruction newDirectionInstruction);

    /**
     * @param currentDirection current direction
     * @param newDirectionInstruction new direction instruction
     * @return new direction
     */
    Direction getNewDirection(Direction currentDirection, char newDirectionInstruction);
}
