class Solution {
    public int majorityElement(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int x : arr) {
            map.put(x, map.getOrDefault(x, 0) + 1);

            if (map.get(x) > arr.length / 2)
                return x;
        }

        return -1;
    }
}
