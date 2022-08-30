import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> subscriptions = new ArrayList<>();
        subscriptions.add(3); // positive
        subscriptions.add(4); // negative
        subscriptions.add(10); // positive
        subscriptions.add(12); // negative
        subscriptions.add(2); // positive
        subscriptions.add(1); // negative
        System.out.println("Прибыль до улучшения: " + profit(subscriptions));
        improveProfit(subscriptions);
        System.out.println("Прибыль после улучшения: " + profit(subscriptions));
    }

    static void improveProfit(List<Integer> subscriptions) {
        int minPositive = Integer.MAX_VALUE;
        int maxNegative = Integer.MIN_VALUE;
        boolean positive = true;
        for (int candidate : subscriptions) {
            if (positive) {
                positive = false;
                if (candidate < minPositive) {
                    minPositive = candidate;
                }
            } else {
                positive = true;
                if (candidate > maxNegative) {
                    maxNegative = candidate;
                }
            }
        }
    }

    static int profit(List<Integer> subscriptions) {
        boolean positive = true;
        int profit = 0;
        for (Integer subscription : subscriptions) {
            if (positive) {
                profit += subscription;
            } else {
                profit -= subscription;
            }
            positive = !positive;
        }
        return profit;
    }

}



