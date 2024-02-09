package org.robotboard.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InstructionTest {

    @Test
    public void testGetInstructionReturnsPlaceWhenPlaceIsPassedInAsAString() {
        assertEquals(Instruction.PLACE, Instruction.getInstruction("PLACE"));
    }

    @Test
    public void testGetInstructionReturnsMoveWhenMoveIsPassedInAsAString() {
        assertEquals(Instruction.MOVE, Instruction.getInstruction("Move"));
    }

    @Test
    public void testGetInstructionReturnsLeftWhenLeftIsPassedInAsAString() {
        assertEquals(Instruction.LEFT, Instruction.getInstruction("left"));
    }

    @Test
    public void testGetInstructionReturnsRightWhenRightIsPassedInAsAString() {
        assertEquals(Instruction.RIGHT, Instruction.getInstruction("RiGhT"));
    }

    @Test
    public void testGetInstructionReturnsReportWhenReportIsPassedInAsAString() {
        assertEquals(Instruction.REPORT, Instruction.getInstruction("reporT"));
    }

    @Test
    public void testGetInstructionReturnsDefaultWhenDefaultIsPassedInAsAString() {
        assertEquals(Instruction.DEFAULT, Instruction.getInstruction("INVALID INSTRUCTION"));
    }

    @Test
    public void testInstructionEnumConstants() {
        assertEquals(Instruction.PLACE, Instruction.valueOf("PLACE"));
        assertEquals(Instruction.MOVE, Instruction.valueOf("MOVE"));
        assertEquals(Instruction.LEFT, Instruction.valueOf("LEFT"));
        assertEquals(Instruction.RIGHT, Instruction.valueOf("RIGHT"));
        assertEquals(Instruction.REPORT, Instruction.valueOf("REPORT"));
    }
}
