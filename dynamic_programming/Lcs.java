package dynamic_programming;

import java.util.*;

//longest common subsequece
public class Lcs {
    // using memoization
    public static int lcs1(String str1, String str2, int n, int m, int dp[][]) {
        if (n == 0 || m == 0) {
            return 0;
        }
        if (dp[n][m] != -1) {
            return dp[n][m];
        }
        if (str1.charAt(n - 1) == str2.charAt(m - 1)) {
            return lcs1(str1, str2, n - 1, m - 1, dp) + 1;
        } else { // 2 cases
            return Math.max(lcs1(str1, str2, n - 1, m, dp), lcs1(str1, str2, n, m - 1, dp));
        }
    }

    public static void main(String args[]) {
        String str1 = "abcdefg";
        String str2 = "adec";
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n + 1][m + 1];
        // for (int[] row : dp) {
        // Arrays.fill(row, -1);
        // }
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(lcs1(str1, str2, n, m, dp));

    }
}
