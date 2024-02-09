package org.robotboard.service;

import org.robotboard.model.Direction;
import org.robotboard.model.Robot;

public interface RobotServiceInterface {

    void place(Robot robot, int xCordinate, int yCordinate, Direction direction);
    String report(Robot robot);
    void move (Robot robot);
    void right (Robot robot) throws Exception;
    void left (Robot robot) throws Exception;
}
