class Solution {
    private static final long MOD = 1_000_000_007;
    private long[] sumSq;
    private long[] sumLin;
    private long[] lazy;

    public int sumCounts(int[] nums) {
        int n = nums.length;
        sumSq = new long[4 * n];
        sumLin = new long[4 * n];
        lazy = new long[4 * n];

        java.util.Map<Integer, Integer> lastPos = new java.util.HashMap<>();
        long totalSum = 0;

        for (int j = 0; j < n; j++) {
            int x = nums[j];
            int i = lastPos.getOrDefault(x, -1);

            update(1, 0, n - 1, i + 1, j, 1);
            lastPos.put(x, j);

            long currentTotal = querySq(1, 0, n - 1, 0, j);
            totalSum = (totalSum + currentTotal) % MOD;
        }

        return (int) totalSum;
    }

    private void pushDown(int node, int l, int r) {
        if (lazy[node] != 0) {
            int mid = l + (r - l) / 2;
            apply(2 * node, l, mid, lazy[node]);
            apply(2 * node + 1, mid + 1, r, lazy[node]);
            lazy[node] = 0;
        }
    }

    private void apply(int node, int l, int r, long val) {
    long len = (r - l + 1);
    // Correct update for sum of squares: sumSq + 2 * val * sumLin + val^2 * len
    sumSq[node] = (sumSq[node] + 2 * val * sumLin[node] % MOD + val * val % MOD * len % MOD) % MOD;
    sumLin[node] = (sumLin[node] + val * len) % MOD;
    lazy[node] = (lazy[node] + val) % MOD;
}
    private void update(int node, int l, int r, int ql, int qr, long val) {
        if (ql > r || qr < l) return;
        if (ql <= l && r <= qr) {
            apply(node, l, r, val);
            return;
        }
        pushDown(node, l, r);
        int mid = l + (r - l) / 2;
        update(2 * node, l, mid, ql, qr, val);
        update(2 * node + 1, mid + 1, r, ql, qr, val);
        sumSq[node] = (sumSq[2 * node] + sumSq[2 * node + 1]) % MOD;
        sumLin[node] = (sumLin[2 * node] + sumLin[2 * node + 1]) % MOD;
    }

    private long querySq(int node, int l, int r, int ql, int qr) {
        if (ql > r || qr < l) return 0;
        if (ql <= l && r <= qr) return sumSq[node];
        pushDown(node, l, r);
        int mid = l + (r - l) / 2;
        long left = querySq(2 * node, l, mid, ql, qr);
        long right = querySq(2 * node + 1, mid + 1, r, ql, qr);
        return (left + right) % MOD;
    }
}