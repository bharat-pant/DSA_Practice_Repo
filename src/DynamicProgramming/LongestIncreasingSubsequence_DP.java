package DynamicProgramming;

public class LongestIncreasingSubsequence_DP {

    static int recursion(int size, int[] a, int i, int j, int[][] dp){

        if(i>= size || j>=size){
            return 0;
        }

        if(i != -1 && dp[i][j] != -1){
            return dp[i][j];
        }

        int count = 0;

        if(i == -1 || a[i]<a[j]){
            count = 1 + recursion(size, a, j, j+1, dp);
        }

        if(i!=-1){
            dp[i][j] =  (Math.max(count, recursion(size, a, i, j+1, dp)));
        }

        return Math.max(count, recursion(size, a, i, j+1, dp));
    }


    public static int longestIncreasingSubsequence(int[] a, int size){
        int[][] dp = new int[size+1][size+1];
        for(int i = 0; i<= size; i++){
            for(int j = 0; j<=size; j++){
                dp[i][j] = -1;
            }
        }

        return recursion(size, a, -1, 0, dp);
    }

    public static void main(String[] args) {
        int[] a = {0,8,4,12,2,10,6,14,1,9,5,13,3,11,7,15};
        int size = 16;

        System.out.println(longestIncreasingSubsequence(a,size));
    }}
