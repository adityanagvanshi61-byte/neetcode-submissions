class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] result = new long[k];
        long[] dp = new long[k];
        int[] active = new int[k];
        int activeCount = 0;
        
        for (int num : nums) {
            long[] nextDp = new long[k];
            int[] nextActive = new int[k];
            int nextCount = 0;
            
            int val = num % k;
            
            nextDp[val]++;
            nextActive[nextCount++] = val;
            
            for (int i = 0; i < activeCount; i++) {
                int r = active[i];
                int nextVal = (int) (((long) r * val) % k);
                
                if (nextDp[nextVal] == 0) {
                    nextActive[nextCount++] = nextVal;
                }
                nextDp[nextVal] += dp[r];
            }
            
            for (int i = 0; i < nextCount; i++) {
                int r = nextActive[i];
                result[r] += nextDp[r];
            }
            
            dp = nextDp;
            active = nextActive;
            activeCount = nextCount;
        }
        
        return result;
    }
}