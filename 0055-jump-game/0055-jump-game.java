class Solution {
    public boolean canJump(int[] nums) {
        int n=nums.length;
        int target=n-1;
        int far=0;
        for(int i=0;i<=target;i++){
            if(i>far) return false;
            far=Math.max(far,i+nums[i]);
            if(far>=target) return true;
        }
        return false;
    }
}