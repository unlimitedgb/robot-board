package org.robotboard;

import org.robotboard.executor.InstructionExecutor;

public class Main {

    public static void main(String[] instructions) {
        InstructionExecutor instructionExecutor = new InstructionExecutor();
        try {
            System.out.println(instructionExecutor.execute(instructions));
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}