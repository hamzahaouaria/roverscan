package com.hhaouari.roverscan.services.impl;

import com.hhaouari.roverscan.entities.Mission;
import com.hhaouari.roverscan.services.MissionControlService;
import com.hhaouari.roverscan.services.RoverControlService;
import com.hhaouari.roverscan.utils.MissionFileReader;

public class MissionControlServiceImpl implements MissionControlService {

    MissionFileReader missionFileReader = new MissionFileReader();
    RoverControlService roverControlService = new RoverControlServiceImpl();

    /**
     * @param fileInput file input
     * @return mission
     */
    @Override
    public Mission execute(String fileInput) {
        Mission mission = missionFileReader.readMission(fileInput);
        runMissionRoversInstructions(mission);
        return mission;
    }

    /**
     * Validate the mission file coordinates and instructions
     * @param fileInput file input
     * @return true if the file input is valid
     */
    @Override
    public boolean validate(String fileInput) {
        return missionFileReader.validateMission(fileInput);
    }

    /**
     * Run the rovers on the plateau based on the instructions
     * The rovers will move one by one in the order they are declared in the file
     * @param mission mission
     */
    @Override
    public void runMissionRoversInstructions(Mission mission) {
        mission.getRovers().forEach(rover -> roverControlService.move(rover, mission.getPlateau()));
    }
}
