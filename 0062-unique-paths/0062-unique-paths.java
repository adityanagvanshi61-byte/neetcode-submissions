class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        // -1 means not calculated yet
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }

        return findPaths(0, 0, m, n, dp);
    }

    public int findPaths(int i, int j, int m, int n, int[][] dp) {

        // Out of bounds
        if (i >= m || j >= n) {
            return 0;
        }

        // Destination reached
        if (i == m - 1 && j == n - 1) {
            return 1;
        }

        // Already calculated
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        // Move right
        int right = findPaths(i, j + 1, m, n, dp);

        // Move down
        int down = findPaths(i + 1, j, m, n, dp);

        // Store result
        dp[i][j] = right + down;

        return dp[i][j];
    }
}