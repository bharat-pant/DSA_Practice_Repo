package DynamicProgramming;

import com.sun.source.tree.BinaryTree;

public class LongestRepeatedSubsequence_DP {

    public static int recursion(String str, int i, int j, int[][] dp) {

        if (i >= str.length() || j >= str.length()) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if ((i !=j ) && str.charAt(i) == str.charAt(j)) {
            return dp[i][j] = (1 + recursion(str, i + 1, j + 1, dp));
        } else {
            return dp[i][j] = Math.max(recursion(str, i + 1, j, dp), recursion(str, i, j + 1, dp));
        }

    }

    public static int longestRepeatedSubsequence(String str) {
        int n = str.length();
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }
        return recursion(str, 0, 1, dp);
    }

    public static void main(String[] args) {
        System.out.println(longestRepeatedSubsequence("yihfrhtriv"));
    }
}
