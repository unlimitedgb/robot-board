package org.robotboard.model;

public enum Instruction {
    PLACE,
    MOVE,
    LEFT,
    RIGHT,
    REPORT,
    DEFAULT;

    public static Instruction getInstruction(String stringInstruction) {
        Instruction finalInstruction = Instruction.DEFAULT;
        for (Instruction instruction: Instruction.values()) {
            if(instruction.name().equalsIgnoreCase(stringInstruction)) {
                finalInstruction = instruction;
            }
        }
        return finalInstruction;
    }
}
