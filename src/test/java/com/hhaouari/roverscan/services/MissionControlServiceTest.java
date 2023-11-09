package com.hhaouari.roverscan.services;

import com.hhaouari.roverscan.constants.TestResources;
import com.hhaouari.roverscan.entities.Mission;
import com.hhaouari.roverscan.entities.Plateau;
import com.hhaouari.roverscan.entities.Rover;
import com.hhaouari.roverscan.entities.enums.Direction;
import com.hhaouari.roverscan.entities.enums.Instruction;
import com.hhaouari.roverscan.services.impl.MissionControlServiceImpl;
import org.apache.logging.log4j.util.IndexedStringMap;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class MissionControlServiceTest {

    private MissionControlService missionControlService;

    private static final Instruction[] instructions1 = new Instruction[]{
            Instruction.L,
            Instruction.M,
            Instruction.L,
            Instruction.M,
            Instruction.L,
            Instruction.M,
            Instruction.L,
            Instruction.M,
            Instruction.M};

    //MMRMMRMRRM
    private static final Instruction[] instructions2 = new Instruction[]{
            Instruction.M,
            Instruction.M,
            Instruction.R,
            Instruction.M,
            Instruction.M,
            Instruction.R,
            Instruction.M,
            Instruction.R,
            Instruction.R,
            Instruction.M};

    Instruction[] outPlateauInstruction = new Instruction[]{
            Instruction.M,
            Instruction.M,
            Instruction.M,
            Instruction.M,
            Instruction.M,
            Instruction.M,
            Instruction.M,
            Instruction.M,
            Instruction.M};


    @BeforeEach
    void setUp() {
        missionControlService = new MissionControlServiceImpl();
    }

    @AfterEach
    void tearDown() {
        missionControlService = null;
    }

    @Test
    void testExecute() {
        Mission mission = missionControlService.execute(TestResources.SAMPLE_TEST_CASE_BASIC);
        Mission expectedMission = new Mission();
        expectedMission.setPlateau(new Plateau(5, 5));
        expectedMission.setRovers(Arrays.asList(
                new Rover(1, 3, Direction.N, instructions1),
                new Rover(5, 1, Direction.E, instructions2)));
        assertEquals(expectedMission, mission);

    }

    @Test
    void testValidateWithValidMission() {
        boolean isValid = missionControlService.validate(TestResources.SAMPLE_TEST_CASE_BASIC);
        assertEquals(true, isValid);
    }

    @Test
    void testValidateWithInvalidPlateau() {
        boolean isValid = missionControlService.validate(TestResources.NOT_VALID_PLATEAU_SIZE);
        assertEquals(false, isValid);
    }

    @Test
    void testValidateWithInvalidRoverPosition() {
        boolean isValid = missionControlService.validate(TestResources.NOT_VALID_ROVER_POSITION);
        assertEquals(false, isValid);
    }

    @Test
    void testRunMissionRoversInstructions() {
        Mission mission = new Mission();
        mission.setPlateau(new Plateau(5, 5));
        mission.setRovers(Arrays.asList(
                new Rover(1, 2, Direction.N, instructions1),
                new Rover(3, 3, Direction.E, instructions2)));
        missionControlService.runMissionRoversInstructions(mission);
        Mission expectedMission = new Mission();
        expectedMission.setPlateau(new Plateau(5, 5));
        expectedMission.setRovers(Arrays.asList(
                new Rover(1, 3, Direction.N, instructions1),
                new Rover(5, 1, Direction.E, instructions2)));
        assertEquals(expectedMission, mission);
    }

    @Test
    void testRunMissionRoversInstructionsOffPlateauLimit() {
        Mission mission = new Mission();
        mission.setPlateau(new Plateau(5, 5));

        mission.setRovers(Arrays.asList(
                new Rover(1, 1, Direction.N, outPlateauInstruction),
                new Rover(1, 1, Direction.E, outPlateauInstruction),
                new Rover(1, 1, Direction.S, outPlateauInstruction),
                new Rover(1, 1, Direction.W, outPlateauInstruction)));

        missionControlService.runMissionRoversInstructions(mission);
        Mission expectedMission = new Mission();
        expectedMission.setPlateau(new Plateau(5, 5));
        expectedMission.setRovers(Arrays.asList(
                new Rover(1, 5, Direction.N, outPlateauInstruction),
                new Rover(5, 1, Direction.E, outPlateauInstruction),
                new Rover(1, 0, Direction.S, outPlateauInstruction),
                new Rover(0, 1, Direction.W, outPlateauInstruction)));

        assertEquals(expectedMission, mission);

    }

}
