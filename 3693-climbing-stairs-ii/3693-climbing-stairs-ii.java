class Solution {
    public int climbStairs(int n, int[] costs) {
        long[] dp = new long[n + 1];
        java.util.Arrays.fill(dp, Long.MAX_VALUE);
        dp[0] = 0;

        for (long j = 1; j <= n; j++) {
            int idx = (int) j;
            for (int i = Math.max(0, idx - 3); i < idx; i++) {
                long jumpCost = costs[idx - 1] + (long) (idx - i) * (idx - i);
                dp[idx] = Math.min(dp[idx], dp[i] + jumpCost);
            }
        }

        return (int) dp[n];
    }
}