package com.hhaouari.roverscan.services;

import com.hhaouari.roverscan.entities.Mission;

public interface MissionControlService {
    Mission execute(String fileInput);

    boolean validate(String fileInput);

    void runMissionRoversInstructions(Mission mission);
}
