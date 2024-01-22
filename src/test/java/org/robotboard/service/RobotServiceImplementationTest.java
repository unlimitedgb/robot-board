package org.robotboard.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.robotboard.common.Direction;
import org.robotboard.model.Robot;

public class RobotServiceImplementationTest {

    RobotServiceImplementation robotServiceImplementation;

    @BeforeEach
    public void setup() {
        robotServiceImplementation = new RobotServiceImplementation();
    }
    @Test
    public void testPlace() {
        Robot robot = new Robot();
        assertNull(robot.getXCordinate());
        assertNull(robot.getYCordinate());
        assertNull(robot.getDirection());

        robotServiceImplementation.place(robot,0, 1, Direction.NORTH);

        assertEquals(0, robot.getXCordinate());
        assertEquals(1, robot.getYCordinate());
        assertEquals(Direction.NORTH, robot.getDirection());
    }

    @Test
    public void testReport() {
        Robot robot = new Robot();
        assertNull(robot.getXCordinate());
        assertNull(robot.getYCordinate());
        assertNull(robot.getDirection());

        robot.setXCordinate(0);
        robot.setYCordinate(1);
        robot.setDirection(Direction.NORTH);

        assertEquals("0, 1, NORTH", robotServiceImplementation.report(robot));
    }

    @ParameterizedTest
    @CsvSource ({"0,0,NORTH,0,1,NORTH", "0,4,NORTH,0,4,NORTH", "4,0,WEST,3,0,WEST", "0,0,WEST,0,0,WEST", "0,0,EAST,1,0,EAST", "4,0,EAST,4,0,EAST", "0,0,SOUTH,0,0,SOUTH", "0,4,SOUTH,0,3,SOUTH"})
    public void testMove(Integer beforeX, Integer beforeY, String beforeDirection, Integer afterX, Integer afterY, String afterDirection) {

        Robot robot = new Robot();
        robot.setXCordinate(beforeX);
        robot.setYCordinate(beforeY);
        robot.setDirection(Direction.valueOf(beforeDirection));

        robotServiceImplementation.move(robot);

        assertEquals(afterX, robot.getXCordinate());
        assertEquals(afterY, robot.getYCordinate());
    }

    @ParameterizedTest
    @CsvSource ({"NORTH,EAST", "WEST,NORTH", "EAST,SOUTH", "SOUTH,WEST"})
    public void testRight(String beforeDirection, String afterDirection) {

        Robot robot = new Robot();
        robot.setDirection(Direction.valueOf(beforeDirection));

        robotServiceImplementation.right(robot);

        assertEquals(Direction.valueOf(afterDirection), robot.getDirection());
    }

    @ParameterizedTest
    @CsvSource ({"NORTH,WEST", "WEST,SOUTH", "EAST,NORTH", "SOUTH,EAST"})
    public void testLeft(String beforeDirection, String afterDirection) {

        Robot robot = new Robot();
        robot.setDirection(Direction.valueOf(beforeDirection));

        robotServiceImplementation.left(robot);

        assertEquals(Direction.valueOf(afterDirection), robot.getDirection());
    }

}
