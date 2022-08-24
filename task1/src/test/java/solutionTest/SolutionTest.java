package solutionTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import solution.Lift;
import solution.PathFinder;
import java.util.HashSet;
import java.util.Set;


public class SolutionTest {

    @Test
    public void lifts3_result3() {
        Set<Lift> lifts = new HashSet<>();
        lifts.add(new Lift(1,2,3));
        lifts.add(new Lift(2,1,2));
        lifts.add(new Lift(3,3,5));
        Assertions.assertEquals(3, PathFinder.findPath(lifts).getLiftList().size());
    }

    @Test
    public void lifts7_result6() {
        Set<Lift> lifts = new HashSet<>();
        lifts.add(new Lift(1,1,2));
        lifts.add(new Lift(2,3,5));
        lifts.add(new Lift(3,2,3));
        lifts.add(new Lift(4,6,10));
        lifts.add(new Lift(5,5,6));
        lifts.add(new Lift(6,5,8));
        lifts.add(new Lift(7,10,11));
        Assertions.assertEquals(6, PathFinder.findPath(lifts).getLiftList().size());
    }



}

