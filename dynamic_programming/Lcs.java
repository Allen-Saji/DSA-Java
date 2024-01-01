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

    // lcs using tabulation
    public static int lcs2(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        int dp[][] = new int[n + 1][m + 1];
        // java mein already initialization mein saare elemnts 0 hote hain, so need do
        // the init case
        // table filling
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    int ans1 = dp[i - 1][j];
                    int ans2 = dp[i][j - 1];
                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }
        return dp[n][m];
    }

    public static int lcSubstring(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int ans = 0; // stores max substring length

        int dp[][] = new int[n + 1][m + 1];
        // java mein already initialization mein saare elemnts 0 hote hain, so need do
        // the init case
        // table filling
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    ans = Math.max(ans, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return ans;
    }

    public static void main(String args[]) {
        String str1 = "abcdefg";
        String str2 = "abcdef";
        // int n = str1.length();
        // int m = str2.length();
        // int dp[][] = new int[n + 1][m + 1];
        // for (int[] row : dp) {
        // Arrays.fill(row, -1);
        // }
        // for (int i = 0; i < n + 1; i++) {
        // for (int j = 0; j < m + 1; j++) {
        // dp[i][j] = -1;
        // }
        // }
        // System.out.println(lcs1(str1, str2, n, m, dp));
        // System.out.println(lcs2(str1, str2));
        System.out.println(lcSubstring(str1, str2));

    }
}
