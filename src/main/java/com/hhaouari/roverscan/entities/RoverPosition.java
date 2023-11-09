package com.hhaouari.roverscan.entities;

import com.hhaouari.roverscan.entities.enums.Direction;
import lombok.Data;

@Data
public class RoverPosition {
    private long x;
    private long y;
    private Direction direction;

}
