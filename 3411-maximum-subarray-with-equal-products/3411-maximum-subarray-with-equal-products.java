class Solution {
    public int maxLength(int[] nums) {
        int n = nums.length;
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            long prod = 1;
            long gcdVal = 0;
            long lcmVal = 1;

            for (int j = i; j < n; j++) {
                long num = nums[j];
                prod *= num;
                gcdVal = (gcdVal == 0) ? num : gcd(gcdVal, num);
                lcmVal = lcm(lcmVal, num);

                if (prod == gcdVal * lcmVal) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }

                // Since nums[k] >= 1, gcd is non-increasing and lcm is non-decreasing.
                // Max possible lcm for elements in [1, 10] is 2520.
                if (prod > 2520L * gcdVal * lcmVal) {
                    break;
                }
            }
        }

        return maxLen;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }
}