package com.hhaouari.roverscan.services.impl;

import com.hhaouari.roverscan.entities.Mission;
import com.hhaouari.roverscan.entities.Rover;
import com.hhaouari.roverscan.services.MissionControlService;
import com.hhaouari.roverscan.services.RoverControlService;
import com.hhaouari.roverscan.utils.MissionFileReader;

import java.util.List;
import java.util.stream.Collectors;

public class MissionControlServiceImpl implements MissionControlService {

    MissionFileReader missionFileReader = new MissionFileReader();
    RoverControlService roverControlService = new RoverControlServiceImpl();

    @Override
    public Mission execute(String fileInput) {
        Mission mission = missionFileReader.readMission(fileInput);
        mission = runMission(mission);
        return runMission(mission);
    }

    @Override
    public boolean validate(String fileInput) {
        return missionFileReader.validateMission(fileInput);

    }

    @Override
    public Mission runMission(Mission mission) {
        List<Rover> rovers = mission.getRovers().stream().map(rover -> {
                    roverControlService.move(rover, mission.getPlateau());
                    return rover;
                }

        ).collect(Collectors.toList());
        return mission;
    }
}
