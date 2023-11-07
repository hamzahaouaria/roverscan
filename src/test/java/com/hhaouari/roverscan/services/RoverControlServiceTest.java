package com.hhaouari.roverscan.services;

import com.hhaouari.roverscan.entities.Plateau;
import com.hhaouari.roverscan.entities.Rover;
import com.hhaouari.roverscan.entities.enums.Direction;
import com.hhaouari.roverscan.services.impl.RoverControlServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RoverControlServiceTest {
    RoverControlService roverControlService = new RoverControlServiceImpl();

    @Test
    public void testMove() {
        Rover rover = new Rover(1, 2, Direction.N, "LMLMLMLMM");
        Plateau plateau = new Plateau(5, 5);
        roverControlService.move(rover, plateau);

        Rover expectedRover = new Rover(1, 3, Direction.N, "LMLMLMLMM");
        assert rover.equals(expectedRover);


    }

}
