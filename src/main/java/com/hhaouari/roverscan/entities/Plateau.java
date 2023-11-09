package com.hhaouari.roverscan.entities;

import lombok.Data;

import java.util.Objects;

@Data
public class Plateau {
    private long height;
    private long width;

    public Plateau(long width, long height) {
        this.width = width;
        this.height = height;
    }

    public Plateau() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Plateau plateau))
            return false;
        return getHeight() == plateau.getHeight() &&
                getWidth() == plateau.getWidth();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHeight(), getWidth());
    }

}
