import java.util.*;

class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int maxFactor = 0;
        long minPrice = Long.MAX_VALUE;

        for (int[] item : items) {
            maxFactor = Math.max(maxFactor, item[0]);
            minPrice = Math.min(minPrice, item[1]);
        }

        int[] freq = new int[maxFactor + 1];
        for (int[] item : items) {
            freq[item[0]]++;
        }

        // multiplesCount[d] = total items with factor divisible by d
        int[] multiplesCount = new int[maxFactor + 1];
        for (int d = 1; d <= maxFactor; d++) {
            for (int m = d; m <= maxFactor; m += d) {
                multiplesCount[d] += freq[m];
            }
        }

        // Build [price, gain] for each item where gain = multiplesCount[factor] - 1
        long[][] entries = new long[n][2];
        for (int i = 0; i < n; i++) {
            int factor = items[i][0];
            long price = items[i][1];
            long gain = multiplesCount[factor] - 1L;
            entries[i][0] = price;
            entries[i][1] = Math.max(0L, gain);
        }

        // Sort items by price ascending
        Arrays.sort(entries, Comparator.comparingLong(a -> a[0]));

        long remBudget = budget;
        long totalItems = 0;

        for (long[] entry : entries) {
            long price = entry[0];
            long gain = entry[1];

            if (gain > 0 && remBudget >= price) {
                // Only worth taking value-2 copies if price <= 2 * minPrice
                // (otherwise buying cheap value-1 copies gives >= items per unit budget)
                if (price <= 2L * minPrice) {
                    long canBuy = Math.min(gain, remBudget / price);
                    totalItems += canBuy * 2L;
                    remBudget -= canBuy * price;
                }
            }
        }

        // Spend any remaining budget on the cheapest item available (1 copy each)
        if (remBudget >= minPrice) {
            totalItems += remBudget / minPrice;
        }

        return (int) totalItems;
    }
}