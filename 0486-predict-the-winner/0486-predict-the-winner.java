class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        Integer[][] memo = new Integer[n][n];
        return solve(nums, 0, n - 1, memo) >= 0;
    }
    
    private int solve(int[] nums, int left, int right, Integer[][] memo) {
        if (left == right) {
            return nums[left];
        }
        
        if (memo[left][right] != null) {
            return memo[left][right];
        }
        
        int chooseLeft = nums[left] - solve(nums, left + 1, right, memo);
        int chooseRight = nums[right] - solve(nums, left, right - 1, memo);
        
        memo[left][right] = Math.max(chooseLeft, chooseRight);
        return memo[left][right];
    }
}