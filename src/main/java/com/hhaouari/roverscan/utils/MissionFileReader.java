package com.hhaouari.roverscan.utils;


import com.hhaouari.roverscan.entities.Mission;
import com.hhaouari.roverscan.entities.Plateau;
import com.hhaouari.roverscan.entities.Rover;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MissionFileReader {


    public Mission readMission(String filePath) {
        CordinateStringReader cordinatStringReader = new CordinateStringReader();
        Mission mission = new Mission();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath)) ) {
            String line;

            line = reader.readLine();
            Plateau plateau = cordinatStringReader.readPlateauCordinate(line);
            mission.setPlateau(plateau);


            while ((line = reader.readLine()) != null) {
                Rover rover = cordinatStringReader.readRoverCordinate(line, reader.readLine());
                mission.addRover(rover);
            }
            return mission;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    public boolean validateMission(String fileInput) {

        try (BufferedReader reader = new BufferedReader(new FileReader(fileInput)) ) {
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
