package com.hhaouari.roverscan.services;

import com.hhaouari.roverscan.entities.Mission;

public interface MissionControlService {
    public Mission execute(String fileInput);

    public boolean validate(String fileInput);

    public Mission runMission(Mission mission);
}
