package com.hhaouari.roverscan.entities;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
public class Mission {
    private Plateau plateau;
    private List<Rover> rovers;

    public Mission() {
        this.rovers = new ArrayList<>();
    }

    public Mission(Plateau plateau, List<Rover> rovers) {
        this.plateau = plateau;
        this.rovers = rovers;
    }

    public void addRover(Rover rover) {
        this.rovers.add(rover);
    }

    public void removeRover(Rover rover) {
        this.rovers.remove(rover);
    }

    public void setPlateauSize(int m, int n) {
        this.plateau.setM(m);
        this.plateau.setN(n);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mission mission)) return false;
        return getPlateau().equals(mission.getPlateau()) &&
                getRovers().equals(mission.getRovers());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPlateau(), getRovers());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Rover rover : rovers) {
            sb.append(rover.toString());
            sb.append("\n");
        }
        return sb.toString();
    }
}
