package dynamic_programming;

import java.util.*;

public class dp1 {

    public static int fibonacci(int n, int[] f) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (f[n] != 0) {
            return f[n];
        }

        f[n] = fibonacci(n - 1, f) + fibonacci(n - 2, f);
        return f[n];
    }

    public static int fibonacciTabulation(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    // climbing stairs problem
    public static int countWays(int n, int ways[]) {
        if (n == 0) {
            return 1;
        }

        if (n < 0) {
            return 0;
        }

        if (ways[n] != -1) {
            return ways[n];
        }
        ways[n] = countWays(n - 1, ways) + countWays(n - 2, ways);

        return ways[n];
    }

    public static int counutWaysTab(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }

        return dp[n];
    }

    public static int zeroOneKnapsack(int wt[], int val[], int W, int n) {
        if (W == 0 || n == 0) {
            return 0;
        }

        if (wt[n - 1] <= W) {// valid
            // include
            int ans1 = val[n - 1] + zeroOneKnapsack(wt, val, W - wt[n - 1], n - 1);
            // exclude
            int ans2 = zeroOneKnapsack(wt, val, W, n - 1);
            return Math.max(ans1, ans2);
        } else {// not valid
            return zeroOneKnapsack(wt, val, W, n - 1);
        }
    }

    public static void main(String[] args) {
        // int n = 5;
        // int f[] = new int[n + 1];
        // System.out.println(fibonacci(n, f));
        // System.out.println(fibonacciTabulation(n));
        // int ways[] = new int[n + 1];
        // Arrays.fill(ways, -1);
        // System.out.println(countWays(n, ways));
        // System.out.println(counutWaysTab(n));
        int val[] = { 15, 14, 10, 45, 30 };
        int wt[] = { 2, 5, 1, 3, 4 };
        int W = 7;
        System.out.println(zeroOneKnapsack(wt, val, W, val.length));
    }

}
