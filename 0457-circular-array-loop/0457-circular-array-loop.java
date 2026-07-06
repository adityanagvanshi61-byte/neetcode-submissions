class Solution {
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
           for (int i = 0; i < n; i++) {
            if (nums[i] == 0) continue;
             int slow = i;
            int fast = i;
            boolean direction = nums[i] > 0;
            while (true) {
                slow = getNext(nums, slow);
                if (isInvalid(nums, slow, direction)) break;
                fast = getNext(nums, fast);
                if (isInvalid(nums, fast, direction)) break;
                fast = getNext(nums, fast);
                if (isInvalid(nums, fast, direction)) break; 
                if (slow == fast) {
                    if (slow == getNext(nums, slow)) break;
                    return true;
                }
            }
            int curr = i;
            int val = nums[i];
            while ((nums[curr] > 0) == (val > 0) && nums[curr] != 0) {
                int next = getNext(nums, curr);
                nums[curr] = 0;
                curr = next;
            }
        }
        
        return false;
    }
    
    private int getNext(int[] nums, int i) {
        int n = nums.length;
        return ((i + nums[i]) % n + n) % n;
    }
    
    private boolean isInvalid(int[] nums, int i, boolean direction) {
        return (nums[i] > 0) != direction || nums[i] == 0;
    }
}