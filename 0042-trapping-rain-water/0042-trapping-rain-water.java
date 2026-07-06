class Solution {
    public int trap(int[] height) {
        int n=height.length;
        if(n==0) return 0;
        int left=0;
        int right=n-1;
        int leftmax=0;
        int rightmax=0;
        int total=0;
        while(left<right){
            if(height[left]<height[right]){
                if(height[left]>=leftmax){
                    leftmax=height[left];
                }
                else{
                    total +=(leftmax-height[left]);
                }
                left++;
            }
            else{
                if(height[right] >= rightmax){
                    rightmax=height[right];
                }
                else{
                    total += (rightmax-height[right]);
                }
                right--;
            }
        }
        return total;
    }
}