package org.robotboard.common;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DirectionTest {

    private final String NORTH_DIRECTION = "North";
    private final String SOUTH_DIRECTION = "SOUTH";
    private final String EAST_DIRECTION = "east";
    private final String WEST_DIRECTION = "WeSt";
    private final String INVALID_DIRECTION = "Invalid";

    @Test
    public void testGetDirectionReturnsNorthWhenNorthIsPassedInAsAString() {
        assertEquals(Direction.NORTH, Direction.getDirection(NORTH_DIRECTION));
    }

    @Test
    public void testGetDirectionReturnsEastWhenEastIsPassedInAsAString() {
        assertEquals(Direction.EAST, Direction.getDirection(EAST_DIRECTION));
    }

    @Test
    public void testGetDirectionReturnsSouthWhenSouthIsPassedInAsAString() {
        assertEquals(Direction.SOUTH, Direction.getDirection(SOUTH_DIRECTION));
    }

    @Test
    public void testGetDirectionReturnsWestWhenWestIsPassedInAsAString() {
        assertEquals(Direction.WEST, Direction.getDirection(WEST_DIRECTION));
    }

    @Test
    public void testGetDirectionReturnsDEFAULTWhenInvalidDirectionIsPassedInAsAString() {
        assertEquals(Direction.DEFAULT, Direction.getDirection(INVALID_DIRECTION));
    }

    @Test
    public void testDirectionEnumConstants() {
        assertEquals(Direction.NORTH, Direction.valueOf("NORTH"));
        assertEquals(Direction.SOUTH, Direction.valueOf("SOUTH"));
        assertEquals(Direction.WEST, Direction.valueOf("WEST"));
        assertEquals(Direction.EAST, Direction.valueOf("EAST"));
    }
}
