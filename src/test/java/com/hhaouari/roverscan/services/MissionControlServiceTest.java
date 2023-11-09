package com.hhaouari.roverscan.services;

import com.hhaouari.roverscan.constants.TestResources;
import com.hhaouari.roverscan.entities.Mission;
import com.hhaouari.roverscan.entities.Plateau;
import com.hhaouari.roverscan.entities.Rover;
import com.hhaouari.roverscan.entities.enums.Direction;
import com.hhaouari.roverscan.services.impl.MissionControlServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class MissionControlServiceTest {

    private MissionControlService missionControlService;

    @BeforeEach
    void setUp() {
        missionControlService = new MissionControlServiceImpl();
    }

    @AfterEach
    void tearDown() {
        missionControlService = null;
    }

    @Test
    void testMission() {
        Mission mission = missionControlService.execute(TestResources.SAMPLE_TEST_CASE_BASIC);
        Mission expectedMission = new Mission();
        expectedMission.setPlateau(new Plateau(5, 5));
        expectedMission.setRovers(Arrays.asList(
                new Rover(1, 3, Direction.N, null),
                new Rover(5, 1, Direction.E, null)));
        assertEquals(expectedMission, mission);

    }

    @Test
    void testMission2() {
        Mission mission = missionControlService.execute(TestResources.SAMPLE_TEST_CASE_CUSTOM);
        Mission expectedMission = new Mission();
        expectedMission.setPlateau(new Plateau(10, 10));
        expectedMission.setRovers(Arrays.asList(
                new Rover(3, 6, Direction.N, null),
                new Rover(2, 2, Direction.E, null),
                new Rover(3, 3, Direction.N, null)));

        assertEquals(expectedMission, mission);

    }

}
