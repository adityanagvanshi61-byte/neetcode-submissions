class Solution {

    public boolean dfs(int node, int[][] graph, int[] vis) {

        vis[node] = 1; // Currently visiting

        for (int v : graph[node]) {

            if (vis[v] == 1) {
                return true; // Cycle detected
            }

            if (vis[v] == 0) {
                if (dfs(v, graph, vis)) {
                    return true;
                }
            }
        }

        vis[node] = 2; // Completely processed and safe

        return false;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {

        int n = graph.length;

        int[] vis = new int[n];

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            if (vis[i] == 0) {
                dfs(i, graph, vis);
            }
        }

        for (int i = 0; i < n; i++) {
            if (vis[i] == 2) {
                ans.add(i);
            }
        }

        return ans;
    }
}