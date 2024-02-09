package org.robotboard.model;

public enum Direction {
    NORTH,
    SOUTH,
    EAST,
    WEST,
    DEFAULT;

    public static Direction getDirection(String stringDirection) {
        Direction finalDirection = Direction.DEFAULT;
        for (Direction direction: Direction.values()) {
            if (direction.name().equalsIgnoreCase(stringDirection)) {
                finalDirection = direction;
            }
        }
        return finalDirection;
    }
}
