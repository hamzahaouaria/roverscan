package com.hhaouari.roverscan.utils;

import com.hhaouari.roverscan.entities.Mission;
import com.hhaouari.roverscan.entities.Plateau;
import com.hhaouari.roverscan.entities.Rover;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MissionFileReader {

    public Mission readMission(String filePath) {
        // TODO: (Refactor) this method is too long, split it into smaller methods
        CoordinateStringReader coordinateStringReader = new CoordinateStringReader();
        Mission mission = new Mission();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            line = reader.readLine();
            Plateau plateau = coordinateStringReader.readPlateauCoordinate(line);
            mission.setPlateau(plateau);

            while ((line = reader.readLine()) != null) {
                Rover rover = coordinateStringReader.readRoverCoordinate(line, reader.readLine());
                mission.addRover(rover);
            }
            return mission;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    public boolean validateMission(String fileInput) {
        // TODO: (Refactor) this method is too long, split it into smaller methods
        try (BufferedReader reader = new BufferedReader(new FileReader(fileInput))) {
            String line;

            line = reader.readLine();
            if (!line.matches("\\d+ \\d+")) {
                return false;
            }

            while (reader.ready()) {
                String Position = reader.readLine();
                String instructions = reader.readLine();
                if (!Position.matches("\\d+ \\d+ [NSEW]") || !instructions.matches("[LRM]+")) {
                    return false;
                }

            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }
}
