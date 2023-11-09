package com.hhaouari.roverscan.utils;

import com.hhaouari.roverscan.entities.Mission;
import com.hhaouari.roverscan.entities.Plateau;
import com.hhaouari.roverscan.entities.Rover;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MissionFileReader {

    CoordinateStringReader coordinateStringReader = new CoordinateStringReader();

    /**
     * Read the mission from the file and return the mission object with Plateau and Rovers
     * @param filePath file path
     * @return Mission object
     */
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

    /**
     * Read two lines from the reader and return the rover object
     * @param reader reader
     * @return Rover object
     * @throws IOException IOException
     */
    private Rover readRoverFromReader(BufferedReader reader) throws IOException {
        String position = reader.readLine();
        String instructions = reader.readLine();
        return coordinateStringReader.readRoverCoordinate(position, instructions);
    }

    /**
     * Read the first line from the reader and return the plateau object
     * @param reader reader
     * @return Plateau object
     * @throws IOException IOException
     */
    private Plateau readPlateauFromReader(BufferedReader reader) throws IOException {
        String line = reader.readLine();
        return coordinateStringReader.readPlateauCoordinate(line);
    }

    /**
     * Validate the mission file coordinates and instructions
     * @param fileInput file input
     * @return true if the file input is valid
     */
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

    /**
     * Validate the rover coordinates and instructions
     * @param reader reader
     * @param plateau plateau
     * @return true if the rover input is valid
     * @throws IOException IOException
     */
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

    /**
     * Validate the plateau coordinates
     * @param plateauLine plateau line
     * @return true if the plateau input is valid
     */
    private static boolean isPlateauInputValid(String plateauLine) {
        if (!plateauLine.matches("\\d+ \\d+"))
            return false;
        String[] plateauCoordinates = plateauLine.split(" ");
        long width = Long.parseLong(plateauCoordinates[0]);
        long height = Long.parseLong(plateauCoordinates[1]);
        return width >= 0 && height >= 0;
    }
}
