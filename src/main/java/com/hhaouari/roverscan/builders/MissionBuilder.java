package com.hhaouari.roverscan.builders;

import com.hhaouari.roverscan.entities.Mission;
import com.hhaouari.roverscan.entities.Plateau;
import com.hhaouari.roverscan.entities.Rover;

import java.util.List;

public class MissionBuilder {
    private Plateau plateau;
    private List<Rover> rovers;

    public MissionBuilder setPlateau(Plateau plateau) {
        this.plateau = plateau;
        return this;
    }

    public MissionBuilder setRovers(List<Rover> rovers) {
        this.rovers = rovers;
        return this;
    }

    public Mission build() {
        return new Mission(plateau, rovers);
    }
}