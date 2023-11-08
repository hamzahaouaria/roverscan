package com.hhaouari.roverscan.services.impl;

import com.hhaouari.roverscan.entities.enums.Direction;
import com.hhaouari.roverscan.services.DirectionHelper;

public class DirectionHelperImpl implements DirectionHelper {

    // TODO: (Refactor) Separate the logic of direction handling in a separate class
    @Override
    public Direction getNewDirection(Direction currentDirection, char newDirectionInstruction) {
        switch (newDirectionInstruction) {
            case 'L':
                switch (currentDirection) {
                    case N:
                        return Direction.W;
                    case S:
                        return Direction.E;
                    case E:
                        return Direction.N;
                    case W:
                        return Direction.S;
                }
            case 'R':
                switch (currentDirection) {
                    case N:
                        return Direction.E;
                    case S:
                        return Direction.W;
                    case E:
                        return Direction.S;
                    case W:
                        return Direction.N;
                }
            default:
                throw new RuntimeException("Invalid direction instruction");
        }
    }
}
