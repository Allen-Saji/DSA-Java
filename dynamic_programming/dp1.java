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

    public static int zeroOneKnapsack(int wt[], int val[], int W, int n, int dp[][]) {
        if (W == 0 || n == 0) {
            return 0;
        }

        if (dp[n][W] != -1) {
            return dp[n][W];
        }

        if (wt[n - 1] <= W) {// valid
            // include
            int ans1 = val[n - 1] + zeroOneKnapsack(wt, val, W - wt[n - 1], n - 1, dp);
            // exclude
            int ans2 = zeroOneKnapsack(wt, val, W, n - 1, dp);
            dp[n][W] = Math.max(ans1, ans2);
            return dp[n][W];
        } else {// not valid
            return zeroOneKnapsack(wt, val, W, n - 1, dp);
        }
    }

    public static int zerOneKnapsackTab(int val[], int wt[], int W) {
        int n = val.length;
        int dp[][] = new int[n + 1][W + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                int v = val[i - 1];// ith item value
                int w = wt[i - 1];// ith item weight
                if (w <= j) {
                    int incProfit = v + dp[i - 1][j - w];// include profit
                    int excProfit = dp[i - 1][j];// exlude profit
                    dp[i][j] = Math.max(incProfit, excProfit);
                } else {
                    int excProfit = dp[i - 1][j];// exlude profit
                    dp[i][j] = excProfit;
                }
            }
        }
        return dp[n][W];
    }

    public static int unboundedKnapsackTab(int val[], int wt[], int W) {
        int n = val.length;
        int dp[][] = new int[n + 1][W + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                int v = val[i - 1];// ith item value
                int w = wt[i - 1];// ith item weight
                if (w <= j) {
                    int incProfit = v + dp[i][j - w];// include profit
                    int excProfit = dp[i - 1][j];// exlude profit
                    dp[i][j] = Math.max(incProfit, excProfit);
                } else {
                    int excProfit = dp[i - 1][j];// exlude profit
                    dp[i][j] = excProfit;
                }
            }
        }
        return dp[n][W];
    }

    public static boolean targetSum(int arr[], int sum) {
        int n = arr.length;
        boolean dp[][] = new boolean[n + 1][sum + 1];
        // i = item && j = target sum
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                int v = arr[i - 1];
                // include
                if (v <= j && dp[i - 1][j - v]) {
                    dp[i][j] = true;
                }
                // exclude
                else if (dp[i - 1][j]) {
                    dp[i][j] = true;
                }
            }
        }
        return dp[n][sum];
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
        // int dp[][] = new int[val.length + 1][W + 1];
        // for (int i = 0; i < (val.length + 1); i++) {
        // for (int j = 0; j < (W + 1); j++) {
        // dp[i][j] = -1;
        // }
        // }
        // System.out.println(zeroOneKnapsack(wt, val, W, val.length, dp));
        // System.out.println(zerOneKnapsackTab(val, wt, W));
        // int arr[] = { 4, 2, 7, 3, 1 };
        // int sum = 10;
        // System.out.println(targetSum(arr, sum));
        System.out.println(unboundedKnapsackTab(val, wt, W));
    }

}
