package com.hhaouari.roverscan.services;

import com.hhaouari.roverscan.entities.Mission;

public interface MissionControlService {

    /**
     * Takes a file input of the mission, validates it and executes it
     * @param fileInput file input
     * @return mission
     */
    Mission execute(String fileInput);

    /**
     * Validate the mission file coordinates and instructions
     * @param fileInput file input
     * @return true if the file input is valid
     */
    boolean validate(String fileInput);

    /**
     * Run the rovers on the plateau based on the instructions
     * The rovers will move one by one in the order they are declared in the file
     * @param mission mission
     */
    void runMissionRoversInstructions(Mission mission);
}
