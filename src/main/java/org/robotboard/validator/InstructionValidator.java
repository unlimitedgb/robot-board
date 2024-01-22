package org.robotboard.validator;

public class InstructionValidator {

    public static boolean doesInstructionsExist(String[] instructions) {
        boolean result = false;
        if (instructions.length != 0) {
            result = true;
        }

        return result;
    }

    public static boolean doesPlaceCommandHaveThreeProperties(String[] initialPosition) {
        boolean result = false;
        if (initialPosition.length == 3) {
            result = true;
        }

        return result;
    }
}
