package DynamicProgramming;

public class FriendsPairProblem_DP {
    public static long friendsPair(int n){
        long[] dp = new long[n+2];
        int mod = 1000000007;
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i<=n; i++){
            dp[i] = (dp[i-1])%mod + ((i-1)%mod * dp[i-2]%mod)%mod;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(friendsPair(6569));
    }
}
