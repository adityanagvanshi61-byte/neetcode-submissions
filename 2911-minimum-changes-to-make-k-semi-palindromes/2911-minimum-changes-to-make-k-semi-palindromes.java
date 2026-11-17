class Solution {
    public int minimumChanges(String s, int k) {
        int n = s.length();

        int[][] cost = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                int len = j - i + 1;
                int min = n;

                for (int d = 1; d < len; d++) {

                    if (len % d != 0) continue;

                    int cnt = 0;

                    for (int x = 0; x < d; x++) {
                        int l = i + x;
                        int r = j - d + 1 + x;

                        while (l < r) {
                            if (s.charAt(l) != s.charAt(r))
                                cnt++;

                            l += d;
                            r -= d;
                        }
                    }

                    min = Math.min(min, cnt);
                }

                cost[i][j] = min;
            }
        }
        int[][] dp = new int[n + 1][k + 1];

        for (int[] row : dp)
            Arrays.fill(row, n);

        dp[n][0] = 0;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 1; j <= k; j++) {

                for (int l = i + 1; l < n; l++) {

                    dp[i][j] = Math.min(
                        dp[i][j],
                        cost[i][l] + dp[l + 1][j - 1]
                    );
                }
            }
        }

        return dp[0][k];
    }
}