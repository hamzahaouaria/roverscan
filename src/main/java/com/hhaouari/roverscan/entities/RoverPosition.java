package com.hhaouari.roverscan.entities;

import com.hhaouari.roverscan.entities.enums.Direction;
import lombok.Data;

// TODO: (Refactor) use position as a rover attribute
@Data
public class RoverPosition {
    private int x;
    private int y;
    private Direction direction;

}
