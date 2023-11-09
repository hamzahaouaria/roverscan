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
            String plateauLine = reader.readLine();
            if (!isPlateauInputValid(plateauLine))
                return false;
            Plateau plateau = coordinateStringReader.readPlateauCoordinate(plateauLine);
            while (reader.ready()) {
                if (!isRoverInputValid(reader, plateau))
                    return false;
            }
            return true;
        } catch (IOException e) {
            return false;
        }

    }

    private static boolean isRoverInputValid(BufferedReader reader, Plateau plateau) throws IOException {
        String position = reader.readLine();
        String instructions = reader.readLine();
        if (!position.matches("\\d+ \\d+ [NSEW]") || !instructions.matches("[LRM]+")) {
            return false;
        } else {
            String[] positionCoordinates = position.split(" ");
            long x = Long.parseLong(positionCoordinates[0]);
            long y = Long.parseLong(positionCoordinates[1]);
            if (x > plateau.getWidth() || y > plateau.getHeight())
                return false;
            return x >= 0 && y >= 0;
        }

    }

    private static boolean isPlateauInputValid(String plateauLine) {
        if (!plateauLine.matches("\\d+ \\d+"))
            return false;
        String[] plateauCoordinates = plateauLine.split(" ");
        long width = Long.parseLong(plateauCoordinates[0]);
        long height = Long.parseLong(plateauCoordinates[1]);
        return width >= 0 && height >= 0;
    }
}
