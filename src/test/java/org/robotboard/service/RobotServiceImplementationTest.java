package org.robotboard.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.robotboard.model.Direction;
import org.robotboard.model.Robot;

import static org.junit.jupiter.api.Assertions.*;

public class RobotServiceImplementationTest {

    Robot robot;
    RobotServiceImplementation robotServiceImplementation;

    @BeforeEach
    public void setup() {
        robot = new Robot();
        robotServiceImplementation = new RobotServiceImplementation();
    }
    @Test
    public void testPlaceShouldReturnValidLocationWhenValidPlaceInstructionIsPassed() {
        assertNull(robot.getXCordinate());
        assertNull(robot.getYCordinate());
        assertNull(robot.getDirection());

        robotServiceImplementation.place(robot,0, 1, Direction.NORTH);

        assertEquals(0, robot.getXCordinate());
        assertEquals(1, robot.getYCordinate());
        assertEquals(Direction.NORTH, robot.getDirection());
    }

    @Test
    public void testReportShouldReturnValidLocationWhenReportInstructionIsPassed() {
        assertNull(robot.getXCordinate());
        assertNull(robot.getYCordinate());
        assertNull(robot.getDirection());

        robot.setXCordinate(0);
        robot.setYCordinate(1);
        robot.setDirection(Direction.NORTH);

        assertEquals("0, 1, NORTH", robotServiceImplementation.report(robot));
    }

    @ParameterizedTest
    @CsvSource ({"0,0,NORTH,0,1,NORTH", "0,4,NORTH,0,4,NORTH", "4,0,WEST,3,0,WEST", "0,0,WEST,0,0,WEST",
            "0,0,EAST,1,0,EAST", "4,0,EAST,4,0,EAST", "0,0,SOUTH,0,0,SOUTH", "0,4,SOUTH,0,3,SOUTH"})
    public void testMoveShouldMoveOrNotMoveRobotWhenValidOrInvalidMoveInstructionIsPAssed(Integer beforeX, Integer beforeY, String beforeDirection, Integer afterX,
                         Integer afterY, String afterDirection) {
        robot.setXCordinate(beforeX);
        robot.setYCordinate(beforeY);
        robot.setDirection(Direction.valueOf(beforeDirection));

        robotServiceImplementation.move(robot);

        assertEquals(afterX, robot.getXCordinate());
        assertEquals(afterY, robot.getYCordinate());
        assertEquals(afterDirection, robot.getDirection().name());
    }

    @ParameterizedTest
    @CsvSource ({"NORTH,EAST", "WEST,NORTH", "EAST,SOUTH", "SOUTH,WEST"})
    public void testRightShouldTurnRobotRightWhenCommandIsInvoked(String beforeDirection, String afterDirection) {
        try {
            robot.setDirection(Direction.valueOf(beforeDirection));
            robotServiceImplementation.right(robot);
            assertEquals(Direction.valueOf(afterDirection), robot.getDirection());
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    @ParameterizedTest
    @CsvSource ({"NORTH,WEST", "WEST,SOUTH", "EAST,NORTH", "SOUTH,EAST"})
    public void testLeftShouldTurnRobotLeftWhenCommandIsInvoked(String beforeDirection, String afterDirection) {
        try {
            robot.setDirection(Direction.valueOf(beforeDirection));
            robotServiceImplementation.left(robot);
            assertEquals(Direction.valueOf(afterDirection), robot.getDirection());
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }
}
