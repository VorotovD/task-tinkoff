package secondSolution;

import java.util.Objects;

public class Lift implements Comparable<Lift> {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lift lift = (Lift) o;
        return startFloor == lift.startFloor && endFloor == lift.endFloor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(startFloor, endFloor);
    }

    @Override
    public int compareTo(Lift o) {

        return (this.getStartFloor()+this.getEndFloor()) - (o.getStartFloor()+o.getEndFloor());
    }
}
