package firstSolution;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Integer> results = new ArrayList<>();
        int intermResult = 0;
        Integer now;

        int n = new Scanner(System.in).nextInt();
        List<Integer> startFloors = new ArrayList<>();
        List<Integer> endFloors = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String floors = new Scanner(System.in).nextLine();
            String[] numbers = floors.split("\\s");
            startFloors.add(Integer.valueOf(numbers[0]));
            endFloors.add(Integer.valueOf(numbers[1]));
        }
        for (Integer startFloor: startFloors) {
            List<Integer> startTrimmed = new ArrayList<>(startFloors);
            List<Integer> endTrimmed = new ArrayList<>(endFloors);
            List<Integer> variants = getVariants(startTrimmed, endFloors, startFloor);
            for (Integer var: variants){
                now = var;
                intermResult++;
                removeVarFomFloors(startTrimmed,endTrimmed,var);
                while (startTrimmed.contains(now)) {
                    variants = getVariants(startTrimmed,endTrimmed,now);
                    variants = variants.stream().sorted().toList();
                    for (Integer var2: variants) {
                    now =var2;
                    intermResult++;
                        removeVarFomFloors(startTrimmed,endTrimmed,var2);
                    }
                }
                results.add(intermResult);
                intermResult=0;
            }
        }

        int max = 0;
        for (int intermRes: results) {
            if (intermRes>max){
                max = intermRes;
            }
        }
        System.out.println(max);

    }

    public static void removeVarFomFloors(List<Integer> startTrimmed, List<Integer> endTrimmed, int variant) {
        int indexVar = endTrimmed.indexOf(variant);
        startTrimmed.remove(indexVar);
        endTrimmed.remove((Integer) variant);
    }

    public static List<Integer> getVariants(List<Integer> startFloors, List<Integer> endFloors, int now) {
        List<Integer> variants = new ArrayList<>();
        for (int i = 0; i < startFloors.size(); i++) {
            if (startFloors.get(i).equals(now)) {
                variants.add(endFloors.get(i));
            }
        }
        return variants;
    }

}
