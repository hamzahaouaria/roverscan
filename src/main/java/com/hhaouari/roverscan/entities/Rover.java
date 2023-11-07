package com.hhaouari.roverscan.entities;

import com.hhaouari.roverscan.entities.enums.Direction;
import lombok.Data;

import java.util.Objects;

@Data
public class Rover {
    private int x;
    private int y;
    private Direction direction;

    public Rover(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rover)) return false;
        Rover rover = (Rover) o;
        return getX() == rover.getX() &&
                getY() == rover.getY() &&
                getDirection() == rover.getDirection();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY(), getDirection());
    }


}
