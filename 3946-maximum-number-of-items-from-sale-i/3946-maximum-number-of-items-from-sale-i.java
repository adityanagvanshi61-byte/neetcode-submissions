class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int[] freeCount = new int[n];

        // Count how many other items j have factor[j] divisible by factor[i]
        for (int i = 0; i < n; i++) {
            int fi = items[i][0];
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && items[j][0] % fi == 0) {
                    count++;
                }
            }
            freeCount[i] = count;
        }

        // dp[b] = max total item copies obtainable with spent budget <= b
        int[] dp = new int[budget + 1];

        for (int i = 0; i < n; i++) {
            int price = items[i][1];
            int bonus = freeCount[i];
            if (price > budget) {
                continue;
            }

            // 1. First copy of item i: unlocks freeCount[i] free copies + 1 bought copy
            for (int b = budget; b >= price; b--) {
                dp[b] = Math.max(dp[b], dp[b - price] + 1 + bonus);
            }

            // 2. Additional copies of item i: +1 copy each, no extra freebies from item i
            for (int b = price; b <= budget; b++) {
                dp[b] = Math.max(dp[b], dp[b - price] + 1);
            }
        }

        int ans = 0;
        for (int b = 0; b <= budget; b++) {
            ans = Math.max(ans, dp[b]);
        }
        return ans;
    }
}