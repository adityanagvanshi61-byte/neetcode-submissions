class Solution {
    public int largestInteger(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i <= nums.length - k; i++) {
            HashSet<Integer> seen = new HashSet<>();
            for (int j = i; j < i + k; j++) {
                seen.add(nums[j]);
            }
            for (int num : seen) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        
        int largestAlmostMissing = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                if (entry.getKey() > largestAlmostMissing) {
                    largestAlmostMissing = entry.getKey();
                }
            }
        }
        
        return largestAlmostMissing;
    }
}