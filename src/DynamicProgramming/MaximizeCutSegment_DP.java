package DynamicProgramming;

public class MaximizeCutSegment_DP {
    public static int function(int n, int x, int y, int z, int[] dp) {
        int x_cut = 0;
        int y_cut = 0;
        int z_cut = 0;

        if (n == 0) {
            return 0;
        }

        if (n < 0) {
            return -100000;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        x_cut = 1 + function(n - x, x, y, z, dp);
        y_cut = 1 + function(n - y, x, y, z, dp);
        z_cut = 1 + function(n - z, x, y, z, dp);

        return dp[n] = Math.max(Math.max(x_cut, y_cut), z_cut);
    }

    public static int maximizeCuts(int n, int x, int y, int z) {
        int max_val = 0;
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = -1;
        }
        max_val = function(n, x, y, z, dp);

        if (max_val < 0) {
            return 0;
        } else {
            return max_val;
        }
    }

    public static void main(String[] args) {
        System.out.println(maximizeCuts(4,2,2,1));
    }
}
