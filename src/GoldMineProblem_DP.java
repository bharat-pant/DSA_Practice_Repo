public class GoldMineProblem_DP {
    public static int recursion(int[][] arr, int n, int m, int x_index, int y_index, int[][] dp) {
        if (x_index < 0 || x_index >= n || y_index >= m) {
            return 0;
        }

        if (dp[x_index][y_index] != -1) {
            return dp[x_index][y_index];
        }


        int topRight = recursion(arr, n, m, x_index - 1, y_index + 1, dp);
        int right = recursion(arr, n, m, x_index, y_index + 1, dp);
        int bottomRight = recursion(arr, n, m, x_index + 1, y_index + 1, dp);

        int val = Math.max(Math.max(topRight, right), bottomRight);
        dp[x_index][y_index] = arr[x_index][y_index] + val;

        return dp[x_index][y_index];
    }

    public static int getGold(int[][] arr, int n, int m) {
        int maxValue = 0;
        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = -1;
            }
        }

        for (int i = 0; i < n; i++) {
            int val = recursion(arr, n, m, i, 0, dp);
            maxValue = Math.max(maxValue, val);
        }
        return maxValue;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 3, 1, 5},
                {2, 2, 4, 1},
                {5, 0, 2, 3},
                {0, 6, 1, 2}
        };

        System.out.println(getGold(arr, 4, 4));
    }
}
