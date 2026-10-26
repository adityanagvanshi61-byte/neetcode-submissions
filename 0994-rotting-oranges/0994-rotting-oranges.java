
class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;

        Queue<Pair<Pair<Integer, Integer>, Integer>> q = new LinkedList<>();

        boolean[][] vis = new boolean[n][m]; // Fixed: dimensions were reversed

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Pair<>(new Pair<>(i, j), 0)); // Fixed Pair syntax
                    vis[i][j] = true;
                }
            }
        }

        while (!q.isEmpty()) {
            int i = q.peek().getKey().getKey();
            int j = q.peek().getKey().getValue();
            int time = q.peek().getValue();
            q.poll();

            ans = Math.max(ans, time);

            // Top
            if (i - 1 >= 0 && !vis[i - 1][j] && grid[i - 1][j] == 1) {
                q.add(new Pair<>(new Pair<>(i - 1, j), time + 1));
                vis[i - 1][j] = true;
            }

            // Right
            if (j + 1 < m && !vis[i][j + 1] && grid[i][j + 1] == 1) {
                q.add(new Pair<>(new Pair<>(i, j + 1), time + 1));
                vis[i][j + 1] = true;
            }

            // Down
            if (i + 1 < n && !vis[i + 1][j] && grid[i + 1][j] == 1) {
                q.add(new Pair<>(new Pair<>(i + 1, j), time + 1));
                vis[i + 1][j] = true;
            }

            // Left
            if (j - 1 >= 0 && !vis[i][j - 1] && grid[i][j - 1] == 1) {
                q.add(new Pair<>(new Pair<>(i, j - 1), time + 1));
                vis[i][j - 1] = true;
            }
        }

        // Check if any fresh orange remains
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !vis[i][j]) {
                    return -1;
                }
            }
        }

        return ans;
    }
}
