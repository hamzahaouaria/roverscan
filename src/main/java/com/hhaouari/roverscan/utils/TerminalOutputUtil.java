package com.hhaouari.roverscan.utils;

import com.hhaouari.roverscan.constants.UserErrorMessagesConstants;
import com.hhaouari.roverscan.entities.Mission;
import com.hhaouari.roverscan.services.MissionControlService;
import com.hhaouari.roverscan.services.impl.MissionControlServiceImpl;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TerminalOutputUtil {

    MissionControlService missionControlService = new MissionControlServiceImpl();
    public String finalTerminalOutput(String fileInput) {
        Mission mission = missionControlService.execute(fileInput);
        return mission.toString();
    }

    public String finalTerminalOutput(String[] args) {
        if (!validateArgs(args))
            return UserErrorMessagesConstants.USAGE;
        String fileInput = args[0];
        if (!missionControlService.validate(fileInput))
            return String.format(UserErrorMessagesConstants.MISSION_FILE_DONT_HAVE_VALID_COORDINATE, fileInput);
        return finalTerminalOutput(fileInput).trim();
    }

    public boolean validateArgs(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide a file path as an argument");
            return false;
        }
        if (args.length > 1) {
            System.out.println("Please provide only one argument");
            return false;
        }
        String fileInput = args[0];

        Path path = Paths.get(fileInput);
        if (!Files.exists(path)) {
            System.out.println("File does not exist");
            return false;
        }

        if (Files.isDirectory(path)) {
            System.out.println("File is a directory");
            return false;
        }

        if (!Files.isReadable(path)) {
            System.out.println("File is not readable");
            return false;
        }
        return true;
    }
}
