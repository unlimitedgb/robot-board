package org.robotboard.model;

import lombok.Getter;
import lombok.Setter;
import org.robotboard.common.Direction;

@Getter
@Setter
public class Robot {
    private Integer xCordinate;
    private Integer yCordinate;
    private Direction direction;
}

