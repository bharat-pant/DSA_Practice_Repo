public class KnapSackProblem_DP {
    public static int KnapSackProblem(int W, int wt[], int val[], int n){
        int[][] dp = new int[n+1][W+1];

        for (int i = 0; i< n+1; i++){
            dp[i][0] = 0;
        }

        for (int i =0; i< W+1; i++){
            dp[0][i] = 0;
        }

        for(int i =1; i<= n; i++){
            for (int j = 1; j<=W; j++){
                if (wt[i-1] > j){
                    dp[i][j] = dp[i-1][j];
                }
                else {
                    dp[i][j] = max(dp[i-1][j], val[i-1] + dp[i-1][j-wt[i-1]]);
                }
            }
        }
        return dp[n][W];
    }
    public static int max(int a, int b){
        if(a>b){
            return a;
        }
        return b;
    }

    public static void main(String[] args) {
        int[] values = {1,2,3};
        int[] weight = {4,5,1};
        int n =3;
        int w = 4;
        System.out.println(KnapSackProblem(w,weight,values,n));
    }
}
