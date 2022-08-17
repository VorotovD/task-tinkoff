package secondSolution;

import java.util.Objects;

public class Lift {
    private final int startFloor;
    private final int endFloor;

    public Lift(int startFloor, int endFloor) {
        this.startFloor = startFloor;
        this.endFloor = endFloor;
    }

    public int getStartFloor() {
        return startFloor;
    }

    public int getEndFloor() {
        return endFloor;
    }
}
