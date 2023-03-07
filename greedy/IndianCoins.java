package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class IndianCoins {
    public static void main(String[] args) {
        Integer coins[] = { 1, 2, 5, 10, 20, 50, 100, 500, 2000 };
        Arrays.sort(coins, Comparator.reverseOrder());

        int amt = 100;
        int coinCount = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < coins.length; i++) {
            if (coins[i] <= amt) {
                while (coins[i] <= amt) {
                    coinCount++;
                    amt -= coins[i];
                }
            }
        }

        System.out.println("Min coin count is = " + coinCount);
    }
}
