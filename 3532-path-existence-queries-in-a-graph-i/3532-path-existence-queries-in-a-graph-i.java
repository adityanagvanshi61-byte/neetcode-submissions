class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
         int[] componentId = new int[n];
        int currentId = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] - nums[i - 1] > maxDiff) {
                currentId++;
            }
            componentId[i] = currentId;
        }
        boolean[] results = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            results[i] = (componentId[u] == componentId[v]);
        }
        
        return results;
    }
}