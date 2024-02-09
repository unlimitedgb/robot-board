package org.robotboard.validator;

public class InstructionValidator {

    public static final String NO_INSTRUCTIONS_RECEIVED_EXCEPTION_MESSAGE = "No instructions received";
    public static final String INVALID_PLACEMENT_INSTRUCTIONS_RECEIVED_EXCEPTION_MESSAGE =
            "Invalid placement instructions received";

    public static boolean doesInstructionsExist(String[] instructions) throws Exception {
        if (instructions.length != 0) {
            return  true;
        }
        throw new Exception(NO_INSTRUCTIONS_RECEIVED_EXCEPTION_MESSAGE);
    }

    public static boolean doesPlaceInstructionHaveThreeProperties(String[] initialPosition) throws Exception {
        if (initialPosition.length == 3) {
            return true;
        }
        throw new Exception(INVALID_PLACEMENT_INSTRUCTIONS_RECEIVED_EXCEPTION_MESSAGE);
    }
}
