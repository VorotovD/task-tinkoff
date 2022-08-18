package secondSolution;

import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        List<Integer> results = new ArrayList<>();
        int intermResult = 0;
        int now;
        int startFloor=100000;
        int n = new Scanner(System.in).nextInt();
        List<Lift> lifts = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String floors = new Scanner(System.in).nextLine();
            String[] numbers = floors.split("\\s");
            lifts.add(new Lift(Integer.parseInt(numbers[0]),Integer.parseInt(numbers[1])));
            if (Integer.parseInt(numbers[0]) < startFloor) {
                startFloor = Integer.parseInt(numbers[0]);
            }
        }
        for (Lift lift : lifts) {
            ArrayList<Lift> liftsForTrim = new ArrayList<>(lifts);
            ArrayList<Lift> variants = getVariants(liftsForTrim, startFloor);
            for (Lift var : variants) {
                now = var.getEndFloor();
                intermResult++;
                liftsForTrim.remove(var);
                while (hasStartVar(liftsForTrim,now)) {
                    variants = getVariants(liftsForTrim, now);
                    //variants = variants.stream().sorted(); // TODO возможно сможет помочь при переборе,реализовать
                    for (Lift var2 : variants) {
                        now = var2.getEndFloor();
                        intermResult++;
                        liftsForTrim.remove(var2);
                    }
                }
                results.add(intermResult);
                intermResult = 0;
            }
        }

        int max = 0;
        for (int intermRes : results) {
            if (intermRes > max) {
                max = intermRes;
            }
        }
        System.out.println(max);

    }

    public static boolean hasStartVar(ArrayList<Lift> lifts, int now) {
        for (Lift lift:lifts) {
            if (lift.getStartFloor() == now) {
                return true;
            }
        }
        return false;
    }

    public static ArrayList<Lift> getVariants(ArrayList<Lift> lifts, int now) {
        ArrayList<Lift> variants = new ArrayList<>();
        for (Lift lift:lifts) {
            if (lift.getStartFloor() == now) {
                variants.add(lift);
            }
        }
        return variants;
    }

}


