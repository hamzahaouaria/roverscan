package com.hhaouari.roverscan.services;

import com.hhaouari.roverscan.entities.Mission;

public interface MissionControlService {
    Mission execute(String fileInput);

    boolean validate(String fileInput);

    Mission runMission(Mission mission);
}
