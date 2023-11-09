package com.hhaouari.roverscan.services.impl;

import com.hhaouari.roverscan.entities.enums.Direction;
import com.hhaouari.roverscan.entities.enums.Instruction;
import com.hhaouari.roverscan.exceptions.DirectionInvalidInstructionException;
import com.hhaouari.roverscan.services.DirectionHelper;

public class DirectionHelperImpl implements DirectionHelper {

    @Override
    public Direction getNewDirection(Direction currentDirection, Instruction newDirectionInstruction) {
        switch (newDirectionInstruction) {
            case L -> {
                return getDirectionAfterLeftTurn(currentDirection);
            }
            case R -> {
                return getDirectionAfterRightTurn(currentDirection);
            }
            default -> throw new DirectionInvalidInstructionException(
                    "Invalid direction instruction: " + newDirectionInstruction);
        }
    }

    @Override
    public Direction getNewDirection(Direction currentDirection, char newDirectionInstruction) {
        return this.getNewDirection(currentDirection, Instruction.valueOf(String.valueOf(newDirectionInstruction)));
    }

    private static Direction getDirectionAfterRightTurn(Direction currentDirection) {
        return switch (currentDirection) {
            case N -> Direction.E;
            case S -> Direction.W;
            case E -> Direction.S;
            case W -> Direction.N;
        };
    }

    private static Direction getDirectionAfterLeftTurn(Direction currentDirection) {
        return switch (currentDirection) {
            case N -> Direction.W;
            case S -> Direction.E;
            case E -> Direction.N;
            case W -> Direction.S;
        };
    }
}
