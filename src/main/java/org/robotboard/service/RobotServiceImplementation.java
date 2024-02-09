package org.robotboard.service;

import org.robotboard.model.Direction;
import org.robotboard.model.Robot;

public class RobotServiceImplementation implements RobotServiceInterface{

    @Override
    public void place(Robot robot, int xCordinate, int yCordinate, Direction direction) {
        robot.setXCordinate(xCordinate);
        robot.setYCordinate(yCordinate);
        robot.setDirection(direction);
    }

    @Override
    public String report(Robot robot) {
        String[] position = {String.valueOf(robot.getXCordinate()),
                String.valueOf(robot.getYCordinate()),
                String.valueOf(robot.getDirection())};
        return String.join(", ", position);
    }

    @Override
    public void move (Robot robot) {
        Direction direction = robot.getDirection();
        Integer yCordinate = robot.getYCordinate();
        Integer xCordinate = robot.getXCordinate();

        if (direction == Direction.NORTH && yCordinate < 4) {
            robot.setYCordinate(yCordinate+1);
        } else if (direction == Direction.SOUTH && yCordinate > 0) {
            robot.setYCordinate(yCordinate-1);
        } else if (direction == Direction.EAST && xCordinate < 4) {
            robot.setXCordinate(xCordinate+1);
        } else if (direction == Direction.WEST && xCordinate > 0) {
            robot.setXCordinate(xCordinate-1);
        }
    }

    @Override
    public void right (Robot robot) throws Exception {
        switch (robot.getDirection()) {
            case WEST:
                robot.setDirection(Direction.NORTH);
                break;
            case SOUTH:
                robot.setDirection(Direction.WEST);
                break;
            case EAST:
                robot.setDirection(Direction.SOUTH);
                break;
            case NORTH:
                robot.setDirection(Direction.EAST);
                break;
            default:
                throw new Exception("Invalid Direction");
        }
    }

    @Override
    public void left (Robot robot) throws Exception {
        switch (robot.getDirection()) {
            case EAST:
                robot.setDirection(Direction.NORTH);
                break;
            case NORTH:
                robot.setDirection(Direction.WEST);
                break;
            case WEST:
                robot.setDirection(Direction.SOUTH);
                break;
            case SOUTH:
                robot.setDirection(Direction.EAST);
                break;
            default:
                throw new Exception("Invalid Direction");
        }
    }
}
