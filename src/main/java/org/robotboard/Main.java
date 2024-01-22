package org.robotboard;

import org.robotboard.service.InstructionServiceImplementation;

import java.util.*;

public class Main {

    public static void main(String[] instructions) {
        InstructionServiceImplementation instructionService = new InstructionServiceImplementation();
        try {
            System.out.println(instructionService.execute(instructions));
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}