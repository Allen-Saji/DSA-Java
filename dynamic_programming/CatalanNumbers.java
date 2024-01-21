package dynamic_programming;

import java.util.*;

public class CatalanNumbers {
    // using memoization
    public static int catalanMem(int n, int dp[]) {
        if (n == 0 || n == 1) {
            return 1;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += catalanMem(i, dp) * catalanMem(n - i - 1, dp);
        }

        return dp[n] = ans;
    }

    public static int catalanTab(int n) {
        int dp[] = new int[n + 1];
        // initialization
        dp[0] = dp[1] = 1;

        // bottom up
        for (int i = 2; i < n + 1; i++) {
            int ans = 0;
            for (int j = 0; j < i; j++) {
                ans += dp[j] * dp[i - j - 1];
            }
            dp[i] = ans;
        }
        return dp[n];
    }

    // same as catalan numbers
    public static int countBSTs(int n) {
        int dp[] = new int[n + 1];
        // initialization
        dp[0] = dp[1] = 1;

        // bottom up
        for (int i = 2; i < n + 1; i++) {
            for (int j = 0; j < i; j++) {
                int left = dp[j];
                int right = dp[i - j - 1];
                dp[i] += left * right;
            }
        }
        return dp[n];
    }

    // same as catalan numbers
    public static int mountainRanges(int n) {
        int dp[] = new int[n + 1];
        // initialization
        dp[0] = dp[1] = 1;

        // bottom up
        for (int i = 2; i < n + 1; i++) {
            for (int j = 0; j < i; j++) {
                int inside = dp[j];
                int outside = dp[i - j - 1];
                dp[i] += inside * outside;
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 4;
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println(catalanMem(n, dp));
        System.out.println(catalanTab(n));
        System.out.println(countBSTs(n));
        System.out.println(mountainRanges(n));
    }
}
