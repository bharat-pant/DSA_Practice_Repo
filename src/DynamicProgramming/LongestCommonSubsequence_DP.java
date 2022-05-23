package DynamicProgramming;

public class LongestCommonSubsequence_DP {

    public static int recursion(int x, int y, String s1, String s2, int i, int j, int[][] dp) {
        if (i >= s1.length() || j >= s2.length()) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = (1 + recursion(x, y, s1, s2, i + 1, j + 1, dp));
        } else {
            return dp[i][j] = Math.max(recursion(x, y, s1, s2, i + 1, j, dp), recursion(x, y, s1, s2, i, j + 1, dp));
        }
    }

    public static int longestCommonSubsequence(int x, int y, String s1, String s2) {
        int[][] dp = new int[x + 1][y + 1];

        for (int i = 0; i <= x; i++) {
            for (int j = 0; j <= y; j++) {
                dp[i][j] = -1;
            }
        }
        return recursion(x, y, s1, s2, 0, 0, dp);
    }

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence(4, 4, "abcde", "acedb"));
    }

}
