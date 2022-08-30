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
        System.out.println("Максимальная прибыль: "+(maxNegative-minPositive));
    }
}
