class Solution {

    // DFS function for traversing the grid
    public void dfs(int i, int j, char[][] grid, boolean[][] vis) {

        // FIX 1: Check boundaries and whether the cell is water or visited
        if (i < 0 || j < 0 || i >= grid.length ||
            j >= grid[0].length || grid[i][j] == '0' || vis[i][j]) {
            return;
        }

        vis[i][j] = true; // Mark the current cell as visited

        // FIX 2: Explore all four neighboring cells
        dfs(i - 1, j, grid, vis); // Up
        dfs(i + 1, j, grid, vis); // Down
        dfs(i, j - 1, grid, vis); // Left
        dfs(i, j + 1, grid, vis); // Right
    }

    public int numIslands(char[][] grid) {

        int n = grid.length;
        int m = grid[0].length; // FIX 3: Rows and columns can differ

        // FIX 4: Use a 2D visited array because the grid is 2D
        boolean[][] vis = new boolean[n][m];

        int islands = 0;

        // FIX 5: Traverse every cell in the grid
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                // FIX 6: Compare character '1', not integer 1
                if (grid[i][j] == '1' && !vis[i][j]) {

                    islands++; // Found a new island

                    dfs(i, j, grid, vis);
                }
            }
        }

        return islands;
    }
}
