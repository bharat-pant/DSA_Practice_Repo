package DynamicProgramming;

import static java.lang.Math.min;

public class PermutationCoefficientProblem_DP {
    public static int PermutationCoefficientProblem(int n, int r){

        int[][] dp = new int[n+1][r+1];
        if (r>n){
            return 0;
        }

        else {
            for(int i = 0; i<=n; i++){
                for(int j = 0; j<=min(i,r); j++){
                    if (j==0){
                        dp[i][j] = 1;
                    }
                    else {
                        dp[i][j] = dp[i-1][j] + (j * dp[i-1][j-1]);
                    }
                }
            }
            return  dp[n][r];
        }
    }

    public static void main(String[] args) {
        System.out.println(PermutationCoefficientProblem(10,2));
    }
}
