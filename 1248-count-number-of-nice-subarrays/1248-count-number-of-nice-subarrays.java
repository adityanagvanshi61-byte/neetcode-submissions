class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        
        int currentPrefixSum = 0;
        int count = 0;
        
        for (int num : nums) {
            currentPrefixSum += (num % 2 != 0) ? 1 : 0;
            
            if (map.containsKey(currentPrefixSum - k)) {
                count += map.get(currentPrefixSum - k);
            }
            
            map.put(currentPrefixSum, map.getOrDefault(currentPrefixSum, 0) + 1);
        }
        
        return count;
    }
}
