package org.robotboard.service;

import org.robotboard.common.Direction;
import org.robotboard.common.Operation;
import org.robotboard.model.Robot;
import org.robotboard.validator.InstructionValidator;

public class InstructionServiceImplementation implements InstructionServiceInterface{

    @Override
    public String execute(String[] instructions) throws Exception {
        String finalLocation = "";
        if (!InstructionValidator.doesInstructionsExist(instructions)) {
            throw new Exception("No instructions received");
        }

        Robot robot = new Robot();
        RobotServiceImplementation robotService = new RobotServiceImplementation();
        boolean foundPlaceCommand = false;

        for (String instruction : instructions) {
            instruction = instruction.toUpperCase();

            if (instruction.startsWith(Operation.PLACE.toString())) {
                foundPlaceCommand = true;
            } else if (foundPlaceCommand) {
                if (instruction.contains(",")) {
                    String[] initialPosition = instruction.split(",");
                    if (!InstructionValidator.doesPlaceCommandHaveThreeProperties(initialPosition)) {
                        throw new Exception("Invalid placement instructions received");
                    }

                    robotService.place(robot, Integer.parseInt(initialPosition[0]),
                            Integer.parseInt(initialPosition[1]),
                            Direction.getDirection(initialPosition[2]));
                } else if (instruction.startsWith(Operation.MOVE.toString())) {
                    robotService.move(robot);
                } else if (instruction.startsWith(Operation.LEFT.toString())) {
                    robotService.left(robot);
                } else if (instruction.startsWith(Operation.RIGHT.toString())) {
                    robotService.right(robot);
                } else if (instruction.startsWith(Operation.REPORT.toString())) {
                    finalLocation = robotService.report(robot);
                } else {
                    throw new Exception("Invalid instructions received");
                }
            }
        }

        return finalLocation;
    }
}
