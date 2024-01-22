package org.robotboard.common;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OperationTest {

    @Test
    public void testOperationEnumConstants() {
        assertEquals(Operation.PLACE, Operation.valueOf("PLACE"));
        assertEquals(Operation.MOVE, Operation.valueOf("MOVE"));
        assertEquals(Operation.LEFT, Operation.valueOf("LEFT"));
        assertEquals(Operation.RIGHT, Operation.valueOf("RIGHT"));
        assertEquals(Operation.REPORT, Operation.valueOf("REPORT"));
    }
}
