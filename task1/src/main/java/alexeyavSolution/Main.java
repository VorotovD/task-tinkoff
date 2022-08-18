package alexeyavSolution;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Set<Lift> liftSet = new HashSet<>();
        liftSet.add(new Lift(1, 1,  3));
        liftSet.add(new Lift(2, 1, 4));
        liftSet.add(new Lift(3, 4, 6));
        liftSet.add(new Lift(5, 3, 7));
        liftSet.add(new Lift(6, 7, 9));
        liftSet.add(new Lift(7, 6, 15));
        liftSet.add(new Lift(8, 15, 17));
        PathFinder.printPath(PathFinder.findPath(liftSet));
    }

}
