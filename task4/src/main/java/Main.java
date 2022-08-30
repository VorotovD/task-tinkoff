public class Main {
    public static void main(String[] args) {
        Integer[] subscriptions = new Integer[6];
        subscriptions[0] = 3; // positive
        subscriptions[1] = 4; // negative
        subscriptions[2] = 10; // positive
        subscriptions[3] = 12; // negative
        subscriptions[4] = 2; // positive
        subscriptions[5] = 1; // negative
        int minPositive = Integer.MAX_VALUE;
        int minIndex = 0;
        int maxNegative = Integer.MIN_VALUE;
        int maxIndex = 0;
        boolean positive = true;
        for (int i = 0; i < subscriptions.length; i++) {
            int candidate = subscriptions[i];
            if (positive) {
                positive = false;
                if (candidate < minPositive) {
                    minPositive = candidate;
                    minIndex = i;
                }
            } else {
                positive = true;
                if (candidate > maxNegative) {
                    maxNegative = candidate;
                    maxIndex = i;
                }
            }
        }
        subscriptions[minIndex] = maxNegative;
        subscriptions[maxIndex] = minPositive;
        System.out.println("Максимальная прибыль: " + getProfit(subscriptions));
    }

    public static int getProfit(Integer[] subscriptions) {
        int profit = 0;
        for (int i = 0; i < subscriptions.length; i++) {
            if (i % 2 == 0) {
                profit += subscriptions[i];
            } else {
                profit -= subscriptions[i];
            }
        }
        return profit;
    }
}
