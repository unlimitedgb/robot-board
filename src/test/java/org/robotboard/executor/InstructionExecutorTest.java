package org.robotboard.executor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InstructionExecutorTest {

    InstructionExecutor instructionExecutor;
    @BeforeEach
    public void setup() {
        instructionExecutor = new InstructionExecutor();
    }

    @Test
    public void testExecuteShouldReturnExceptionWhenNoInstructionsArePassedIn() {
        String[] instructions = {};
        Exception thrown = Assertions.assertThrows(Exception.class, () -> {
            instructionExecutor.execute(instructions);
        });
        Assertions.assertEquals("No instructions received", thrown.getMessage());
    }

    @Test
    public void testExecuteShouldReturnValidResponseWhenInvalidInstructionsArePassedInBeforePlace() throws Exception {
        String[] instructions = {"START", "PLACE", "0,0,NORTH", "MOVE", "RIGHT", "REPORT"};
        String result = instructionExecutor.execute(instructions);
        Assertions.assertEquals("0, 1, EAST", result);
    }

    @Test
    public void testExecuteShouldReturnValidResponseWhenInvalidPlacementInstructionsArePassedInBeforePlace() throws Exception {
        String[] instructions = {"0; 7; 8", "PLACE", "0,0,NORTH", "MOVE", "LEFT", "MOVE", "MOVE", "MOVE", "REPORT"};
        String result = instructionExecutor.execute(instructions);
        Assertions.assertEquals("0, 1, WEST", result);
    }

    @Test
    public void testExecuteShouldReturnExceptionWhenInvalidInstructionsArePassedInAfterPlace() throws Exception {
        String[] instructions = {"0; 7; 8", "PLACE", "STOP", "MOVE", "LEFT", "MOVE", "MOVE", "MOVE", "REPORT"};
        Exception thrown = Assertions.assertThrows(Exception.class, () -> {
            instructionExecutor.execute(instructions);
        });
        Assertions.assertEquals("Invalid instructions received", thrown.getMessage());
    }

    @Test
    public void testExecuteShouldReturnExceptionWhenInvalidPlacementInstructionsArePassedInAfterPlace() throws Exception {
        String[] instructions = {"0; 7; 8", "PLACE", "0:1,SOUTH", "MOVE", "LEFT", "MOVE", "MOVE", "MOVE", "REPORT"};
        Exception thrown = Assertions.assertThrows(Exception.class, () -> {
            instructionExecutor.execute(instructions);
        });
        Assertions.assertEquals("Invalid placement instructions received", thrown.getMessage());
    }
}
