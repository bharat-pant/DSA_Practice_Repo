package DynamicProgramming;

import static java.lang.Math.min;

public class BinomialCoefficientProblem_DP {
    public static int nCr(int n, int r) {
        int[][] dp = new int[n + 1][r + 1];
        if (n < r) {
            return 0;
        }
        else {
            for (int i = 0; i <= n; i++) {
                for (int j = 0; j <= min(i,r); j++) {
                    if (j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j])%1000000007;
                    }
                }
            }
            return dp[n][r]%1000000007;
        }
    }

    public static void main(String[] args) {
        System.out.println(nCr(3,2));
    }
}
