package com.hhaouari.roverscan.services.impl;

import com.hhaouari.roverscan.entities.Mission;
import com.hhaouari.roverscan.services.MissionControlService;
import com.hhaouari.roverscan.services.RoverControlService;
import com.hhaouari.roverscan.utils.MissionFileReader;

public class MissionControlServiceImpl implements MissionControlService {

    MissionFileReader missionFileReader = new MissionFileReader();
    RoverControlService roverControlService = new RoverControlServiceImpl();

    @Override
    public Mission execute(String fileInput) {
        Mission mission = missionFileReader.readMission(fileInput);
        runMissionRoversInstructions(mission);
        return mission;
    }

    @Override
    public boolean validate(String fileInput) {
        return missionFileReader.validateMission(fileInput);
    }

    @Override
    public void runMissionRoversInstructions(Mission mission) {
        mission.getRovers().forEach(rover ->
                roverControlService.move(rover, mission.getPlateau())
        );
    }
}
