class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);

        HashSet<Integer> set = new HashSet<>();
        List<Integer> ans = new ArrayList<>();

        for (int e : nums) {
            set.add(e);
        }

        for (int i = nums[0]; i <= nums[nums.length - 1]; i++) {
            if (!set.contains(i)) {
                ans.add(i);
            }
        }

        return ans;
    }
}