package org.robotboard.executor;

import org.robotboard.model.Direction;
import org.robotboard.model.Instruction;
import org.robotboard.model.Robot;
import org.robotboard.service.RobotServiceImplementation;
import org.robotboard.validator.InstructionValidator;

public class InstructionExecutor {
    private static final String PLACE_PARAMETER_DELIMITER= ",";
    RobotServiceImplementation robotService = new RobotServiceImplementation();

    public String execute(String[] instructions) throws Exception {
        String finalLocation = "";
        if(InstructionValidator.doesInstructionsExist(instructions)) {
            boolean foundPlaceInstruction = false;
            Robot robot = new Robot();
            for (String instruction : instructions) {
                if (Instruction.getInstruction(instruction) == Instruction.PLACE) {
                    foundPlaceInstruction = true;
                } else if (foundPlaceInstruction) {
                    if (instruction.contains(PLACE_PARAMETER_DELIMITER)) {
                        String[] initialPosition = instruction.split(PLACE_PARAMETER_DELIMITER);
                        if (InstructionValidator.doesPlaceInstructionHaveThreeProperties(initialPosition)) {
                            robotService.place(robot, Integer.parseInt(initialPosition[0]),
                                    Integer.parseInt(initialPosition[1]),
                                    Direction.getDirection(initialPosition[2]));
                        }
                    } else if (Instruction.getInstruction(instruction) == Instruction.MOVE) {
                        robotService.move(robot);
                    } else if (Instruction.getInstruction(instruction) == Instruction.LEFT) {
                        robotService.left(robot);
                    } else if (Instruction.getInstruction(instruction) == Instruction.RIGHT) {
                        robotService.right(robot);
                    } else if (Instruction.getInstruction(instruction) == Instruction.REPORT) {
                        finalLocation = robotService.report(robot);
                    } else {
                        throw new Exception("Invalid instructions received");
                    }
                }
            }
        }
        return finalLocation;
    }
}
