class Solution {
    int count = 0;

    public int totalNQueens(int n) {
        boolean[] cols = new boolean[n];
        boolean[] posDiag = new boolean[2 * n];
        boolean[] negDiag = new boolean[2 * n];
        
        backtrack(0, n, cols, posDiag, negDiag);
        return count;
    }

    private void backtrack(int row, int n, boolean[] cols, boolean[] posDiag, boolean[] negDiag) {
        if (row == n) {
            count++;
            return;
        }

        for (int col = 0; col < n; col++) {
            int pDiag = row + col;
            int nDiag = row - col + n;

            if (cols[col] || posDiag[pDiag] || negDiag[nDiag]) {
                continue;
            }

            cols[col] = true;
            posDiag[pDiag] = true;
            negDiag[nDiag] = true;

            backtrack(row + 1, n, cols, posDiag, negDiag);

            cols[col] = false;
            posDiag[pDiag] = false;
            negDiag[nDiag] = false;
        }
    }
}