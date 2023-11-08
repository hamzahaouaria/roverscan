package com.hhaouari.roverscan.utils;

import com.hhaouari.roverscan.entities.Mission;
import com.hhaouari.roverscan.entities.Plateau;
import com.hhaouari.roverscan.entities.Rover;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MissionFileReader {

    CoordinateStringReader coordinateStringReader = new CoordinateStringReader();

    public Mission readMission(String filePath) {
        Mission mission = new Mission();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            Plateau plateau = readPlateauFromReader(reader);
            mission.setPlateau(plateau);

            while (reader.ready()) {
                Rover rover = readRoverFromReader(reader);
                mission.addRover(rover);
            }
            return mission;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    private Rover readRoverFromReader(BufferedReader reader) throws IOException {
        String position = reader.readLine();
        String instructions = reader.readLine();
        return coordinateStringReader.readRoverCoordinate(position, instructions);
    }

    private Plateau readPlateauFromReader(BufferedReader reader) throws IOException {
        String line = reader.readLine();
        return coordinateStringReader.readPlateauCoordinate(line);
    }

    public boolean validateMission(String fileInput) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileInput))) {
            if (isPlateauInputValid(reader)) return false;

            while (reader.ready()) {
                if (isRoverInputValid(reader)) return false;
            }
            return true;
        } catch (IOException e) {
            return false;
        }

    }

    private static boolean isRoverInputValid(BufferedReader reader) throws IOException {
        String position = reader.readLine();
        String instructions = reader.readLine();
        return !position.matches("\\d+ \\d+ [NSEW]") || !instructions.matches("[LRM]+");
    }

    private static boolean isPlateauInputValid(BufferedReader reader) throws IOException {
        String line = reader.readLine();
        return !line.matches("\\d+ \\d+");
    }
}
