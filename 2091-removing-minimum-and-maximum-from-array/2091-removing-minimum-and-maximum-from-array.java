class Solution {
    public int minimumDeletions(int[] nums) {

        int n = nums.length;

        int max = nums[0];
        int min = nums[0];

        int firstidx = 0;
        int lastidx = 0;

        for (int i = 1; i < n; i++) {

            if (nums[i] > max) {
                max = Math.max(max, nums[i]);
                firstidx = i;
            }

            if (nums[i] < min) {
                min = Math.min(min, nums[i]);
                lastidx = i;
            }
        }

        int left = Math.max(firstidx, lastidx) + 1;

        int right = n - Math.min(firstidx, lastidx);

        int both = Math.min(firstidx, lastidx) + 1
                 + n - Math.max(firstidx, lastidx);

        return Math.min(left, Math.min(right, both));
    }
}