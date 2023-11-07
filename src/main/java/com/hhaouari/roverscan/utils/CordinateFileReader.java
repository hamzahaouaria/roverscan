package com.hhaouari.roverscan.utils;

import com.hhaouari.roverscan.entities.Plateau;

public class CordinateFileReader {


    public Plateau readPlateauCordinate(String s) {
        String[] cordinates = s.split(" ");
        return new Plateau(Integer.parseInt(cordinates[0]), Integer.parseInt(cordinates[1]));
    }
}
