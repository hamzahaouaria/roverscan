package com.hhaouari.roverscan.utils;

import com.hhaouari.roverscan.entities.Mission;
import com.hhaouari.roverscan.entities.Plateau;
import com.jayway.jsonpath.internal.Utils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CordinateFileReaderTest {

    private static String FILE_PATH = "src/test/resources/input-case-1.txt.txt";


    @Test
    public void testReadingPlateauCordinate() {
        CordinateFileReader cordinateFileReader = new CordinateFileReader();
        Plateau plateau = cordinateFileReader.readPlateauCordinate("5 5");
        Plateau expectedPlateau = new Plateau(5, 5);

        assert plateau.equals(expectedPlateau);
    }
    


}
