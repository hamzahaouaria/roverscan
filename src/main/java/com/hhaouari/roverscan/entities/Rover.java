package com.hhaouari.roverscan.entities;

import com.hhaouari.roverscan.entities.enums.Direction;
import com.hhaouari.roverscan.entities.enums.Instruction;
import lombok.Data;

import java.util.Arrays;
import java.util.Objects;

@Data
public class Rover {
    private long x;
    private long y;
    private Direction direction;
    private Instruction[] instructions;

    public Rover() {
    }

    public Rover(long x, long y, Direction direction, Instruction[] instructions) {
        setRoverPosition(x, y);
        this.direction = direction;
        this.instructions = instructions;
    }

    private void setRoverPosition(long x, long y) {
        this.x = x;
        this.y = y;
    }

    public Rover(long x, long y, String direction, String instructions) {
        setRoverPosition(x, y);
        this.setDirection(direction);
        this.setInstructions(instructions);
    }

    public Rover(long x, long y, Direction direction, String instructions) {
        setRoverPosition(x, y);
        this.setDirection(direction);
        this.setInstructions(instructions);
    }

    public void setInstructions(String instructions) {
        this.instructions = Arrays.stream(instructions.split(""))
                .map(Instruction::valueOf)
                .toArray(Instruction[]::new);
    }

    public void setInstructions(Instruction[] instructions) {
        this.instructions = instructions;
    }

    public void setDirection(String direction) {
        this.direction = Direction.valueOf(direction);
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Rover rover))
            return false;
        return getX() == rover.getX() &&
                getY() == rover.getY() &&
                getDirection().equals(rover.getDirection());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY(), getDirection(), Arrays.hashCode(getInstructions()));
    }

    @Override
    public String toString() {
        return x + " " + y + " " + direction;
    }

}
