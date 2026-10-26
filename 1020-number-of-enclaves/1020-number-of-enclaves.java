class Solution {
    public void dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length
                || grid[i][j] == 0) {
            return;
        }
        grid[i][j] = 0;
        dfs(grid, i - 1, j); // Up
        dfs(grid, i + 1, j); // Down
        dfs(grid, i, j - 1); // Left
        dfs(grid, i, j + 1); // Right
    }

    public int numEnclaves(int[][] grid) {

        int n = grid.length;    // Number of rows
        int m = grid[0].length; // Number of columns

        // Step 1: Traverse the top and bottom boundaries
        for (int j = 0; j < m; j++) {

            // If the top boundary cell is land,
            // remove all land connected to it using DFS
            if (grid[0][j] == 1) {
                dfs(grid, 0, j);
            }

            // If the bottom boundary cell is land,
            // remove all land connected to it using DFS
            if (grid[n - 1][j] == 1) {
                dfs(grid, n - 1, j);
            }
        }

        // Step 2: Traverse the left and right boundaries
        for (int i = 0; i < n; i++) {

            // If the left boundary cell is land,
            // remove all land connected to it using DFS
            if (grid[i][0] == 1) {
                dfs(grid, i, 0);
            }

            // If the right boundary cell is land,
            // remove all land connected to it using DFS
            if (grid[i][m - 1] == 1) {
                dfs(grid, i, m - 1);
            }
        }

        // Step 3: Count the remaining land cells
        // These cells cannot reach the boundary,
        // so they are enclave cells
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                // Count every land cell that remains
                if (grid[i][j] == 1) {
                    count++;
                }
            }
        }

        // Return the total number of enclave cells
        return count;
    }
}
