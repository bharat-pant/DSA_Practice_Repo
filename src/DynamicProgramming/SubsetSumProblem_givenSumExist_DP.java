package DynamicProgramming;

public class SubsetSumProblem_givenSumExist_DP {
    static Boolean isSubsetSum(int N, int arr[], int sum){
        boolean[][] dp = new boolean[N+1][sum+1];

        for(int i = 0; i< N+1; i++){
            dp[i][0] = false;
        }

        for(int i = 0; i<sum+1; i++){
            dp[0][i] = false;
        }

        for(int i = 1; i< N+1; i++){
            for(int j = 1; j< sum+1; j++){

                if(j < arr[i-1]){
                    dp[i][j] = dp[i-1][j];
                }

                else if(j == arr[i-1]){
                    dp[i][j] = true;
                }
                else{
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i-1]];
                }
            }
        }
        return dp[N][sum];
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        System.out.println(isSubsetSum(4, arr, 11));
    }
}
