package DynamicProgramming;

public class UniquePaths_DP {
    public static int recursion(int m, int n, int[][] dp){
        if(n == 1 || m == 1){
            return 1;
        }

        if(dp[m][n] != -1){
            return dp[m][n];
        }

        dp[m][n] = recursion(m-1,n, dp) + recursion(m,n-1, dp);
        return dp[m][n];
    }
    public static int uniquePaths(int m, int n) {

        int[][] dp = new int[m+1][n+1];

        for(int i = 0; i<m+1; i++){
            for(int j = 0; j<=n; j++){
                dp[i][j] = -1;
            }
        }
        return recursion(m,n, dp);
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(10,10));
    }
}
