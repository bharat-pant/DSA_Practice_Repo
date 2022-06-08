package DynamicProgramming;

public class CountSortedVowelString_DP {
    public static int countSortedVowelString(int n){
        int[][] dp = new int[5][n];

        dp[0][0] = 1;
        dp[1][0] = 1;
        dp[2][0] = 1;
        dp[3][0] = 1;
        dp[4][0] = 1;

        for(int i = 1; i<n; i++){
            dp[0][i] = dp[0][i-1] + dp[1][i-1] + dp[2][i-1] + dp[3][i-1] + dp[4][i-1];
            dp[1][i] = dp[1][i-1] + dp[2][i-1] + dp[3][i-1] + dp[4][i-1];
            dp[2][i] = dp[2][i-1] + dp[3][i-1] + dp[4][i-1];
            dp[3][i] = dp[3][i-1] + dp[4][i-1];
            dp[4][i] = dp[4][i-1];
        }
        return dp[0][n-1] + dp[1][n-1] + dp[2][n-1] + dp[3][n-1] + dp[4][n-1];
    }

    public static void main(String[] args) {
        System.out.println(countSortedVowelString(33));
    }
}
