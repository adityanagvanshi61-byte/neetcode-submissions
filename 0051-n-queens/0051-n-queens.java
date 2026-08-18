class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        
        boolean[] cols = new boolean[n];
        boolean[] posDiag = new boolean[2 * n];
        boolean[] negDiag = new boolean[2 * n];
        
        backtrack(0, n, board, res, cols, posDiag, negDiag);
        return res;
    }

    private void backtrack(int row, int n, char[][] board, List<List<String>> res, boolean[] cols, boolean[] posDiag, boolean[] negDiag) {
        if (row == n) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(new String(board[i]));
            }
            res.add(list);
            return;
        }

        for (int col = 0; col < n; col++) {
            int pDiag = row + col;
            int nDiag = row - col + n;

            if (cols[col] || posDiag[pDiag] || negDiag[nDiag]) {
                continue;
            }

            board[row][col] = 'Q';
            cols[col] = true;
            posDiag[pDiag] = true;
            negDiag[nDiag] = true;

            backtrack(row + 1, n, board, res, cols, posDiag, negDiag);

            board[row][col] = '.';
            cols[col] = false;
            posDiag[pDiag] = false;
            negDiag[nDiag] = false;
        }
    }
}