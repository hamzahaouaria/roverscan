package com.hhaouari.roverscan.services;

import com.hhaouari.roverscan.entities.Mission;
import com.hhaouari.roverscan.entities.Plateau;
import com.hhaouari.roverscan.entities.Rover;
import com.hhaouari.roverscan.entities.enums.Direction;
import com.hhaouari.roverscan.services.impl.MissionControlServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class MissionControlServiceTest {

    private  static String FILE_PATH = "src/test/resources/input-case-1.txt";

    private  static String FILE_PATH_2 = "src/test/resources/input-case-2.txt";

    private  static String FILE_PATH_3_PERFORMENCE = "src/test/resources/input-case-3.txt";
    private MissionControlService missionControlService = new MissionControlServiceImpl();

    @Test
    public void testMission() {
        Mission mission = missionControlService.execute(FILE_PATH);
        Mission expectedMission = new Mission();
        expectedMission.setPlateau(new Plateau(5, 5));
        expectedMission.setRovers(Arrays.asList(
                new Rover(1, 3, Direction.N, null),
                new Rover(5, 1, Direction.E, null)
        ));
        assertEquals(expectedMission,mission);

    }

    @Test
    public void testMission2() {
        Mission mission = missionControlService.execute(FILE_PATH_2);
        Mission expectedMission = new Mission();
        expectedMission.setPlateau(new Plateau(10, 10));
        expectedMission.setRovers(Arrays.asList(
                new Rover(3, 6, Direction.N, null),
                new Rover(2, 2, Direction.E, null),
                new Rover(3, 3, Direction.N, null)
        ));

        assertEquals(expectedMission,mission);



    }

}
