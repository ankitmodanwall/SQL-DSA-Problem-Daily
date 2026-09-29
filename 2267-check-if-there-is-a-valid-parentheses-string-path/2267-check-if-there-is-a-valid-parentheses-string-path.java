import java.util.*;

class Solution {
    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if ((m + n - 1) % 2 != 0)
            return false;

        int maxbal = m + n;
        boolean[][][] dp = new boolean[m][n][maxbal];
        int start = grid[0][0] == '(' ? 1 : -1;
        if (start < 0)
            return false;

        dp[0][0][start] = true;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int bal = 0; bal < maxbal; bal++) {
                    if(!dp[i][j][bal]) continue;
                    if (i + 1 < m) {
                        int nb = bal + (grid[i + 1][j] == '(' ? 1 : -1);
                        if (nb >= 0 && nb < maxbal)
                            dp[i + 1][j][nb] = true;
                    }
                    if (j + 1 < n) {

                        int nb = bal + (grid[i][j + 1] == '(' ? 1 : -1);
                        if (nb >= 0 && nb < maxbal)
                            dp[i][j + 1][nb] = true;
                    }
                }
            }
        }
        return dp[m - 1][n - 1][0];
    }
}