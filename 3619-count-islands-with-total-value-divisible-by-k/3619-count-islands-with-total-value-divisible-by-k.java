class Solution {
    private int m, n;
    private int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int countIslands(int[][] grid, int k) {
        m = grid.length;
        n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // An island consists of positive integers (land > 0)
                if (grid[i][j] > 0 && !visited[i][j]) {
                    long islandSum = dfs(grid, visited, i, j);
                    if (islandSum % k == 0) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    private long dfs(int[][] grid, boolean[][] visited, int r, int c) {
        visited[r][c] = true;
        long currentSum = grid[r][c];

        for (int[] dir : directions) {
            int nr = r + dir[0];
            int nc = c + dir[1];

            if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] > 0 && !visited[nr][nc]) {
                currentSum += dfs(grid, visited, nr, nc);
            }
        }

        return currentSum;
    }
}