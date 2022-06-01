package DynamicProgramming;

public class LongestCommonSubsequence_3Strings_DP {
    public static int recursion(String A, String B, String C, int i, int j, int k, int n1, int n2, int n3, int[][][] dp){

        if (i >= n1 || j>= n2 || k >=n3){
            return 0;
        }

        if(dp[i][j][k] != -1){
            return dp[i][j][k];
        }

        if (A.charAt(i) == B.charAt(j) && B.charAt(j) == C.charAt(k)){
            return dp[i][j][k] =  1 + recursion(A,B,C,i+1,j+1,k+1,n1,n2,n3,dp);
        }else{
            return dp[i][j][k] = Math.max(Math.max(recursion(A,B,C,i+1,j,k,n1,n2,n3,dp), recursion(A,B,C,i,j+1,k,n1,n2,n3,dp)), recursion(A,B,C,i,j,k+1,n1,n2,n3,dp));
        }

    }

    public static int longestCommonSubsequence_3Strings(String A, String B, String C, int n1, int n2, int n3){
        int[][][] dp = new int[n1+1][n2+1][n3+1];

        for(int i = 0; i<=n1; i++){
            for(int j = 0; j<=n2; j++){
                for(int k = 0; k<=n3; k++){
                    dp[i][j][k] = -1;
                }
            }
        }
        return (recursion(A,B,C,0,0,0,n1,n2,n3,dp));
    }

    public static void main(String[] args) {
        String A = "abcdefgh";
        String B = "abcefj";
        String C = "abcdegh";
        int n1 = 8; int n2 = 6; int n3 = 7;
        System.out.println(longestCommonSubsequence_3Strings(A,B,C,n1,n2,n3));
    }
}
