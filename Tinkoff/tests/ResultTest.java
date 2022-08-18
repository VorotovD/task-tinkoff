import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import secondSolution.Lift;
import secondSolution.Main2;

import java.util.ArrayList;
import java.util.List;

public class ResultTest {

    @Test
    public void lifts3_result3() {
        List<Lift> lifts = new ArrayList<>();
        lifts.add(new Lift(1,2));
        lifts.add(new Lift(2,3));
        lifts.add(new Lift(3,4));
        Assertions.assertEquals(3, Main2.getMaxPath(lifts,1));
    }

    //@Test
    public void lifts7_result6() {
        List<Lift> lifts = new ArrayList<>();
        lifts.add(new Lift(1,2));
        lifts.add(new Lift(3,4));
        lifts.add(new Lift(5,6));
        lifts.add(new Lift(2,6));
        lifts.add(new Lift(6,7));
        lifts.add(new Lift(4,5));
        lifts.add(new Lift(2,3));
        Assertions.assertEquals(6, Main2.getMaxPath(lifts,1));
    }
    @Test
    public void lifts3_result3_repeat1() {
        List<Lift> lifts = new ArrayList<>();
        lifts.add(new Lift(1,2));
        lifts.add(new Lift(2,3));
        lifts.add(new Lift(2,2));
        Assertions.assertEquals(3, Main2.getMaxPath(lifts,1));
    }

    @Test
    public void lifts4_result4_repeat2() {
        List<Lift> lifts = new ArrayList<>();
        lifts.add(new Lift(1,2));
        lifts.add(new Lift(2,3));
        lifts.add(new Lift(2,2));
        lifts.add(new Lift(3,3));
        Assertions.assertEquals(4, Main2.getMaxPath(lifts,1));
    }

    @Test
    public void lifts7_result6_repeat1() {
        List<Lift> lifts = new ArrayList<>();
        lifts.add(new Lift(2,6));
        lifts.add(new Lift(5,6));
        lifts.add(new Lift(2,5));
        lifts.add(new Lift(2,2));
        lifts.add(new Lift(6,8));
        lifts.add(new Lift(2,2));
        lifts.add(new Lift(0,2));
        Assertions.assertEquals(6, Main2.getMaxPath(lifts,0));
    }

    @Test
    public void sortTest() {
        List<Lift> lifts = new ArrayList<>();
        lifts.add(new Lift(1,2));
        lifts.add(new Lift(3,4));
        lifts.add(new Lift(5,6));
        lifts.add(new Lift(2,6));
        lifts.add(new Lift(6,7));
        lifts.add(new Lift(4,5));
        lifts.add(new Lift(2,3));
        sort(lifts);
        for (Lift lift:lifts) {
            System.out.println(lift.getStartFloor() + " " + lift.getEndFloor());
        }
    }

    public void sort(List<Lift> lifts) {
        lifts.sort(Lift::compareTo);
        for (int i = 0; i<=lifts.size()-3;i++) {
            if (lifts.get(i).getEndFloor() > lifts.get(i+1).getEndFloor() || lifts.get(i).getEndFloor() > lifts.get(i+2).getEndFloor()) {
                if (lifts.get(i).getEndFloor() > lifts.get(i+1).getEndFloor()) {
                    Lift toMove = lifts.get(i+1);
                    lifts.remove(i+1);
                    lifts.add(i+1,lifts.get(i));
                    lifts.remove(i);
                    lifts.add(i,toMove);
                }
                if (lifts.get(i).getEndFloor() > lifts.get(i+2).getEndFloor()) {
                    Lift toMove = lifts.get(i+2);
                    lifts.remove(i+2);
                    lifts.add(i+2,lifts.get(i));
                    lifts.remove(i);
                    lifts.add(i,toMove);
                }
                }

            }
        }
    }

