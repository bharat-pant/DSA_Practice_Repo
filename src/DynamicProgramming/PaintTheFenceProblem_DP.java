package DynamicProgramming;

public class PaintTheFenceProblem_DP {
    public static int paintTheFence (int n, int k){
        int[][] dp = new int[3][n];
        dp[0][0] = 0;
        dp[1][0] = k;
        dp[2][0] = dp[0][0] + dp[1][0];

        for(int i = 1; i<n; i++){
            dp[0][i] = dp[1][i-1];
            dp[1][i] = dp[2][i-1] * (k-1);
            dp[2][i] = dp[0][i] + dp[1][i];
        }
        return dp[2][n-1];
    }

    public static void main(String[] args) {
        System.out.println(paintTheFence(3,2));
    }
}
