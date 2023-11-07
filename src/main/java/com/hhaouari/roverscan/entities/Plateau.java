package com.hhaouari.roverscan.entities;

import lombok.Data;

import java.util.Objects;

@Data
public class Plateau {
    // Plateau size m x n
    private int m;
    private int n;

    public Plateau(int m, int n) {
        this.m = m;
        this.n = n;
    }

    public Plateau() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Plateau)) return false;
        Plateau plateau = (Plateau) o;
        return getM() == plateau.getM() &&
                getN() == plateau.getN();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getM(), getN());
    }


}
