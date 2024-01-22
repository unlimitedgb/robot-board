package org.robotboard.service;

import org.robotboard.common.Direction;
import org.robotboard.model.Robot;

public interface RobotServiceInterface {

    void place(Robot robot, int xCordinate, int yCordinate, Direction direction);
    String report(Robot robot);
    void move (Robot robot);
    void right (Robot robot);
    void left (Robot robot);
}
