class Solution {
    public int findGCD(int[] nums) {
        Arrays.sort(nums);
        int i = nums[0];
        int j = nums[nums.length - 1];
        return gcd(i, j);
    }
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}