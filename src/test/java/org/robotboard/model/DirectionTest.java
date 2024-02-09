package org.robotboard.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class DirectionTest {

    @Test
    public void testGetDirectionReturnsNorthWhenNorthIsPassedInAsAString() {
        assertEquals(Direction.NORTH, Direction.getDirection("North"));
    }

    @Test
    public void testGetDirectionReturnsEastWhenEastIsPassedInAsAString() {
        assertEquals(Direction.EAST, Direction.getDirection("east"));
    }

    @Test
    public void testGetDirectionReturnsSouthWhenSouthIsPassedInAsAString() {
        assertEquals(Direction.SOUTH, Direction.getDirection("SOUTH"));
    }

    @Test
    public void testGetDirectionReturnsWestWhenWestIsPassedInAsAString() {
        assertEquals(Direction.WEST, Direction.getDirection("WeSt"));
    }

    @Test
    public void testGetDirectionReturnsDEFAULTWhenInvalidDirectionIsPassedInAsAString() {
        assertEquals(Direction.DEFAULT, Direction.getDirection("Invalid Direction"));
    }

    @Test
    public void testDirectionEnumConstants() {
        assertEquals(Direction.NORTH, Direction.valueOf("NORTH"));
        assertEquals(Direction.SOUTH, Direction.valueOf("SOUTH"));
        assertEquals(Direction.WEST, Direction.valueOf("WEST"));
        assertEquals(Direction.EAST, Direction.valueOf("EAST"));
    }
}
