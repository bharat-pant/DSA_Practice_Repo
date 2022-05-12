public class EditDistanceProblem_DP {
    public static int editDistance (String s, String t){
        int n = s.length();
        int m = t.length();

        int[][] dp = new int[n+1][m+1];

        for( int i = 0; i<n+1; i++){
            dp[i][0] = i;
        }
        for (int j = 0; j<m+1; j++){
            dp[0][j] = j;
        }

        for(int i=1; i< n+1; i++){
            for(int j = 1; j<m+1; j++){
                char c = s.charAt(i-1);
                char d = t.charAt(j-1);
                if (c == d){
                    dp[i][j] = dp[i-1][j-1];
                }
                else {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1],dp[i-1][j]), dp[i][j-1]) +1;
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        System.out.println(editDistance("abcd","dbca"));
    }
}
