class Solution {
    public int[][] generateMatrix(int n) {
        int[][] m = new int[n][n];
        int t = 0, b = n - 1, l = 0, r = n - 1, num = 1;
        while (t <= b && l <= r) {
            for (int i = l; i <= r; i++) m[t][i] = num++;
            t++;
            for (int i = t; i <= b; i++) m[i][r] = num++;
            r--;
            for (int i = r; i >= l; i--) m[b][i] = num++;
            b--;
            for (int i = b; i >= t; i--) m[i][l] = num++;
            l++;
        }
        return m;
    }
}