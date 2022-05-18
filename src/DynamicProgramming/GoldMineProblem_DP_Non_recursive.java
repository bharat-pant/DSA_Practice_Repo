package DynamicProgramming;

public class GoldMineProblem_DP_Non_recursive {

    public static int goldMinePro(int n, int m, int[][] arr){
        int[][] dp = new int[n+3][m+1];
        for(int j = 1; j<=m; j++){
            for(int i = 1; i<=n; i++){
                dp[i+1][j] = arr[i-1][j-1] + Math.max(Math.max(dp[i][j-1],dp[i+1][j-1]),dp[i+2][j-1]);
            }
        }
        int maxVal = -10000000;
        for(int i = 0; i<=n+1; i++){
            maxVal = Math.max(maxVal,dp[i][m]);
        }
        return maxVal;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 3, 1, 5},
                {2, 2, 4, 1},
                {5, 0, 2, 3},
                {0, 6, 1, 2}};

        System.out.println(goldMinePro(4,4 ,arr));
    }
}
