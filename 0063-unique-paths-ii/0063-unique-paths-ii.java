class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m + 1][n + 1];

        for (int i = m; i >= 0; i--) {
            for (int j = n; j >= 0; j--) {
                if (i >= m || j >= n || obstacleGrid[i][j] == 1)
                    dp[i][j] = 0;
                else if (i == m - 1 && j == n - 1)
                    dp[i][j] = 1;
                else
                    dp[i][j] = dp[i][j + 1] + dp[i + 1][j];
            }
        }

        return dp[0][0];
    }
}