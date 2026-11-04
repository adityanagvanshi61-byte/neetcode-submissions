class Solution {

    public void dfs(boolean[][] vis, char[][] board,
                    int[] delrow, int[] delcol, int row, int col) {

        vis[row][col] = true; 

        for (int i = 0; i < 4; i++) {
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];

            if (nrow >= 0 && nrow < board.length &&
                ncol >= 0 && ncol < board[0].length &&
                !vis[nrow][ncol] && board[nrow][ncol] == 'O') {

                dfs(vis, board, delrow, delcol, nrow, ncol);
            }
        }
    }

    public void solve(char[][] board) {

        int n = board.length;
        int m = board[0].length;

        int[] delrow = {-1, 0, +1, 0};
        int[] delcol = {0, +1, 0, -1};

        boolean[][] vis = new boolean[n][m];

        for (int j = 0; j < m; j++) {

            if (!vis[0][j] && board[0][j] == 'O') {
                dfs(vis, board, delrow, delcol, 0, j);
            }

            if (!vis[n - 1][j] && board[n - 1][j] == 'O') {
                dfs(vis, board, delrow, delcol, n - 1, j);
            }
        }

       
        for (int i = 0; i < n; i++) {

            if (!vis[i][0] && board[i][0] == 'O') {
                dfs(vis, board, delrow, delcol, i, 0);
            }

            if (!vis[i][m - 1] && board[i][m - 1] == 'O') {
                dfs(vis, board, delrow, delcol, i, m - 1);
            }
        }

       
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (!vis[i][j] && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
}