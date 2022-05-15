public class SubsetSumProblem_equalPartition_DP {
    public static int subsetSum_equalPartition(int N, int arr[]){
        int sum = 0;
        int w = 0;
        for(int i =0; i<arr.length; i++) {
            sum = sum + arr[i];
        }

        if(sum%2 ==1){
            return 0;
        }

        w = sum/2;
        boolean[][] dp = new boolean[N+1][w+1];

        for(int i = 0; i< N+1; i++){
            dp[0][i] = false;
            dp[i][0] = false;
        }

        for(int i = 1; i< N+1; i++){
            for(int j = 1; j< w+1; j++){
                if(j<arr[i-1]){
                    dp[i][j] = dp[i-1][j];
                }

                else if (arr[i-1] == j){
                    dp[i][j] = true;
                }
                else {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i-1]];
                }
            }
        }
        if (dp[N][w]){
            return 1;
        }
        else{
            return 0;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        System.out.println(subsetSum_equalPartition(4,arr));
    }
}
