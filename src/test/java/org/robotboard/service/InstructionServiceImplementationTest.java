package org.robotboard.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InstructionServiceImplementationTest {

    InstructionServiceImplementation instructionServiceImplementation;
    @BeforeEach
    public void setup() {
        instructionServiceImplementation = new InstructionServiceImplementation();
    }

    @Test
    public void testExecuteAndReturnExceptionWhenNoInstructionsArePassedIn() {
        String[] instructions = {};
        Exception thrown = Assertions.assertThrows(Exception.class, () -> {
            instructionServiceImplementation.execute(instructions);
        });

        Assertions.assertEquals("No instructions received", thrown.getMessage());
    }

    @Test
    public void testExecuteAndReturnValidResponseWhenInvalidInstructionsArePassedInBeforePlace() throws Exception {
        String[] instructions = {"START", "PLACE", "0,0,NORTH", "MOVE", "RIGHT", "REPORT"};
        String result = instructionServiceImplementation.execute(instructions);
        Assertions.assertEquals("0, 1, EAST", result);
    }

    @Test
    public void testExecuteAndReturnValidResponseWhenInvalidPlacementInstructionsArePassedInBeforePlace() throws Exception {
        String[] instructions = {"0; 7; 8", "PLACE", "0,0,NORTH", "MOVE", "LEFT", "MOVE", "MOVE", "MOVE", "REPORT"};
        String result = instructionServiceImplementation.execute(instructions);
        Assertions.assertEquals("0, 1, WEST", result);
    }

    @Test
    public void testExecuteAndReturnExceptionWhenInvalidInstructionsArePassedInAfterPlace() throws Exception {
        String[] instructions = {"0; 7; 8", "PLACE", "STOP", "MOVE", "LEFT", "MOVE", "MOVE", "MOVE", "REPORT"};
        Exception thrown = Assertions.assertThrows(Exception.class, () -> {
            instructionServiceImplementation.execute(instructions);
        });

        Assertions.assertEquals("Invalid instructions received", thrown.getMessage());
    }

    @Test
    public void testExecuteAndReturnExceptionWhenInvalidPlacementInstructionsArePassedInAfterPlace() throws Exception {
        String[] instructions = {"0; 7; 8", "PLACE", "0:1,SOUTH", "MOVE", "LEFT", "MOVE", "MOVE", "MOVE", "REPORT"};
        Exception thrown = Assertions.assertThrows(Exception.class, () -> {
            instructionServiceImplementation.execute(instructions);
        });

        Assertions.assertEquals("Invalid placement instructions received", thrown.getMessage());
    }
}
