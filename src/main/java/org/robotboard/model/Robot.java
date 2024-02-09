package org.robotboard.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Robot {
    private Integer xCordinate;
    private Integer yCordinate;
    private Direction direction;
}

