class Solution {
    public int missingInteger(int[] nums) {
        int n=nums.length;
        HashSet<Integer> set= new HashSet<>();
        int sum=nums[0];
        for(int k=0;k<n-1;k++){
            if(nums[k]+1 == nums[k+1]){
                sum=sum+nums[k+1];
            }
            else {
                break;
            }
  

        }
        for(int i = 0; i <n;i++){
            set.add(nums[i]);
        }
        while(set.contains(sum)){
            sum++;
            
        }
        return sum;

    }
}