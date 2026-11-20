import java.util.*;

class Solution {
    public int maxSelectedElements(int[] nums) {
        Arrays.sort(nums);
        Map<Integer, Integer> dp = new HashMap<>();
        int res = 0;

        for (int x : nums) {
            res = Math.max(res, dp.merge(x + 1, dp.getOrDefault(x, 0) + 1, Math::max));
            res = Math.max(res, dp.merge(x, dp.getOrDefault(x - 1, 0) + 1, Math::max));
        }

        return res;
    }
}