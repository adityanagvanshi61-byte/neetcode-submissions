class Solution {
    public int uniquePaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int MOD = 1_000_000_007;

        int[][] dp = new int[m][n];
        dp[0][0] = 1;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (dp[r][c] == 0) continue;

                long ways = dp[r][c];

                // --- 1. Move Right ---
                int[] nextRight = simulate(grid, m, n, r, c + 1, 0); // 0 = moving right
                if (nextRight != null) {
                    dp[nextRight[0]][nextRight[1]] = (int) ((dp[nextRight[0]][nextRight[1]] + ways) % MOD);
                }

                // --- 2. Move Down ---
                int[] nextDown = simulate(grid, m, n, r + 1, c, 1); // 1 = moving down
                if (nextDown != null) {
                    dp[nextDown[0]][nextDown[1]] = (int) ((dp[nextDown[0]][nextDown[1]] + ways) % MOD);
                }
            }
        }

        return dp[m - 1][n - 1];
    }

    // dir: 0 = moving Right, 1 = moving Down
    private int[] simulate(int[][] grid, int m, int n, int r, int c, int dir) {
        while (r >= 0 && r < m && c >= 0 && c < n) {
            // Reached destination or empty cell
            if (r == m - 1 && c == n - 1) {
                return new int[]{r, c};
            }
            if (grid[r][c] == 0) {
                return new int[]{r, c};
            }

            // Hit mirror: reflect
            if (dir == 0) {
                r++;
                dir = 1;
            } else {
                c++;
                dir = 0;
            }
        }
        return null; // Out of bounds
    }
}