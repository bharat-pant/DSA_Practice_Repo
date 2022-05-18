package DynamicProgramming;

public class CoinChangeProblem_DP {
    public static long  CoinChangeProblem(int S[], int m, int n){
        long[][] dp = new long[m+1][n+1];

        for(int i = 0; i<n+1; i++){
            dp[0][i] = 0;
        }

        for(int i = 0; i< m+1; i++){
            dp[i][0] = 1;
        }

        for(int i = 1; i<=m; i++){
            for(int j = 1; j<=n; j++){
                if(S[i-1] <= j){
                    dp[i][j] = dp[i-1][j] + dp[i][j-S[i-1]];
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[m][n];
    }
    public static void main(String[] args) {
        int S[] = {1,2,3};
        System.out.println(CoinChangeProblem(S,3,4));
    }
}
