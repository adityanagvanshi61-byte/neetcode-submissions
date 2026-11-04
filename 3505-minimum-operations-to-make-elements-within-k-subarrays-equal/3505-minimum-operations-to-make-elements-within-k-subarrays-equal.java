import java.util.*;

class Solution {
    // Helper multiset using TreeSet storing indices to handle duplicate values
    static class SlidingMedian {
        int[] nums;
        int leftSize, rightSize;
        long leftSum = 0, rightSum = 0;

        Comparator<Integer> cmp;
        TreeSet<Integer> left;
        TreeSet<Integer> right;

        SlidingMedian(int[] nums, int x) {
            this.nums = nums;
            this.leftSize = (x + 1) / 2;
            this.rightSize = x / 2;

            this.cmp = (a, b) -> {
                if (nums[a] != nums[b]) {
                    return Integer.compare(nums[a], nums[b]);
                }
                return Integer.compare(a, b);
            };

            this.left = new TreeSet<>(cmp);
            this.right = new TreeSet<>(cmp);
        }

        void add(int idx) {
            if (left.isEmpty() || nums[idx] <= nums[left.last()]) {
                left.add(idx);
                leftSum += nums[idx];
            } else {
                right.add(idx);
                rightSum += nums[idx];
            }
            balance();
        }

        void remove(int idx) {
            if (left.contains(idx)) {
                left.remove(idx);
                leftSum -= nums[idx];
            } else {
                right.remove(idx);
                rightSum -= nums[idx];
            }
            balance();
        }

        private void balance() {
            while (left.size() > leftSize) {
                int moved = left.pollLast();
                leftSum -= nums[moved];
                right.add(moved);
                rightSum += nums[moved];
            }
            while (left.size() < leftSize && !right.isEmpty()) {
                int moved = right.pollFirst();
                rightSum -= nums[moved];
                left.add(moved);
                leftSum += nums[moved];
            }
        }

        long getCost() {
            long median = nums[left.last()];
            long leftCost = (long) left.size() * median - leftSum;
            long rightCost = rightSum - (long) right.size() * median;
            return leftCost + rightCost;
        }
    }

    public long minOperations(int[] nums, int x, int k) {
        int n = nums.length;
        int numWindows = n - x + 1;
        long[] cost = new long[numWindows];

        // 1. Calculate costs for all windows of size x
        SlidingMedian sm = new SlidingMedian(nums, x);
        for (int i = 0; i < x; i++) {
            sm.add(i);
        }
        cost[0] = sm.getCost();

        for (int i = x; i < n; i++) {
            sm.remove(i - x);
            sm.add(i);
            cost[i - x + 1] = sm.getCost();
        }

        // 2. DP to pick k non-overlapping windows of size x
        // dp[j][i] = min cost to select j windows ending at or before index i
        long INF = (long) 1e18;
        long[] prev = new long[n + 1];
        long[] curr = new long[n + 1];

        for (int j = 1; j <= k; j++) {
            Arrays.fill(curr, INF);
            for (int i = j * x; i <= n; i++) {
                // Option 1: Do not place a window ending at index i - 1
                curr[i] = curr[i - 1];

                // Option 2: Place a window ending at index i - 1 (starts at i - x)
                long prevCost = (j == 1) ? 0 : prev[i - x];
                if (prevCost != INF) {
                    curr[i] = Math.min(curr[i], prevCost + cost[i - x]);
                }
            }
            System.arraycopy(curr, 0, prev, 0, n + 1);
        }

        return prev[n];
    }
}