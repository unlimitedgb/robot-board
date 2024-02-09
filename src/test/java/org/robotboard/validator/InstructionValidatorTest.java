package org.robotboard.validator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.fail;

public class InstructionValidatorTest {

    @Test
    public void testDoesInstructionsExistShouldReturnTrueWhenInstructionsArePassedIn() {
        try {
            String[] instructions = {"INSTRUCTION_1", "INSTRUCTION_2"};
            assertTrue(InstructionValidator.doesInstructionsExist(instructions));
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    @Test
    public void testDoesInstructionsExistShouldReturnExceptionWhenNoInstructionsArePassedIn() {
        String[] instructions = {};

        Exception exception = assertThrows(Exception.class, () -> {
            InstructionValidator.doesInstructionsExist(instructions);
        });

        String expectedMessage = "No instructions received";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testDoesPlaceInstructionHaveThreePropertiesShouldReturnTrueWhenCorrectInstructionIsPassedIn() {
        try {
            String[] instructions = {"0", "1", "NORTH"};
            assertTrue(InstructionValidator.doesPlaceInstructionHaveThreeProperties(instructions));
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    @Test
    public void testDoesPlaceInstructionHaveThreePropertiesShouldThrowExceptionWhenInorrectInstructionIsPassedIn() {
        String[] placeInstruction = {"0", "1;NORTH"};

        Exception exception = assertThrows(Exception.class, () -> {
            InstructionValidator.doesPlaceInstructionHaveThreeProperties(placeInstruction);
        });

        String expectedMessage = "Invalid placement instructions received";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
}