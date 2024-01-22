package org.robotboard.validator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class InstructionValidatorTest {

    @Test
    public void testDoesInstructionsExistWhenNoInstructionsArePassedIn() {
        String[] instructions = {};
        assertFalse(InstructionValidator.doesInstructionsExist(instructions));
    }

    @Test
    public void testDoesInstructionsExistWhenInstructionsArePassedIn() {
        String[] instructions = {"INSTRUCTION_1", "INSTRUCTION_2"};
        assertTrue(InstructionValidator.doesInstructionsExist(instructions));
    }

    @Test
    public void testDoesPlaceCommandHaveThreePropertiesWhenCorrectInstructionIsPassedIn() {
        String[] instructions = {"0", "1", "NORTH"};
        assertTrue(InstructionValidator.doesPlaceCommandHaveThreeProperties(instructions));
    }

    @Test
    public void testDoesPlaceCommandHaveThreePropertiesWhenInorrectInstructionIsPassedIn() {
        String[] instructions = {"0", "1;NORTH"};
        assertFalse(InstructionValidator.doesPlaceCommandHaveThreeProperties(instructions));
    }
}
