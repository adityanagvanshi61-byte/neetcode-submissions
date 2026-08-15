class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n=nums.length;
        double curr=0,maxsum=-Double.MAX_VALUE;
        int left=0;
        for(int right=0;right<n;right++){
            curr += nums[right];
            if(right-left+1==k){
            maxsum=Math.max(curr,maxsum);
            curr -= nums[left];
            left++;
            }
           
        }
        return maxsum/k;
    }
}