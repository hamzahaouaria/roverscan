package com.hhaouari.roverscan.services;

import com.hhaouari.roverscan.entities.enums.Direction;
import com.hhaouari.roverscan.services.impl.DirectionHelperImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class DirectionHelperTest {
    DirectionHelper directionHelper = new DirectionHelperImpl();

    @Test
    public void testGetNewDirectionNToL() {
        Direction direction = directionHelper.getNewDirection(Direction.N, 'L');
        assert direction.equals(Direction.W);
    }

    @Test
    public void testGetNewDirectionNToR() {
        Direction direction = directionHelper.getNewDirection(Direction.N, 'R');
        assert direction.equals(Direction.E);
    }

    @Test
    public void testGetNewDirectionSToL() {
        Direction direction = directionHelper.getNewDirection(Direction.S, 'L');
        assert direction.equals(Direction.E);
    }

    @Test
    public void testGetNewDirectionSToR() {
        Direction direction = directionHelper.getNewDirection(Direction.S, 'R');
        assert direction.equals(Direction.W);
    }

    @Test
    public void testGetNewDirectionEToL() {
        Direction direction = directionHelper.getNewDirection(Direction.E, 'L');
        assert direction.equals(Direction.N);
    }

    @Test
    public void testGetNewDirectionEToR() {
        Direction direction = directionHelper.getNewDirection(Direction.E, 'R');
        assert direction.equals(Direction.S);
    }

    @Test
    public void testGetNewDirectionWToL() {
        Direction direction = directionHelper.getNewDirection(Direction.W, 'L');
        assert direction.equals(Direction.S);
    }

    @Test
    public void testGetNewDirectionWToR() {
        Direction direction = directionHelper.getNewDirection(Direction.W, 'R');
        assert direction.equals(Direction.N);
    }

    @Test
    public void testGetNewDirectionNToM() {
        Direction direction = directionHelper.getNewDirection(Direction.N, 'M');
         assertThrows(Exception.class, () -> {
            directionHelper.getNewDirection(Direction.N, 'M');
        });
    }

}
