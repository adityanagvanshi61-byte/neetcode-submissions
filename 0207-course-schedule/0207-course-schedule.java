class Solution {

    public boolean dfs(int node, List<List<Integer>> adj, int[] vis) {

        vis[node] = 1;

        for (int v : adj.get(node)) {

            if (vis[v] == 1) {
                return false; // Cycle detected
            }

            if (vis[v] == 0) {
                if (!dfs(v, adj, vis)) {
                    return false;
                }
            }
        }

        vis[node] = 2;

        return true;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        // Build directed graph
        for (int[] p : prerequisites) {
            int u = p[1];
            int v = p[0];

            adj.get(u).add(v);
        }

        int[] vis = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {

            if (vis[i] == 0) {
                if (!dfs(i, adj, vis)) {
                    return false;
                }
            }
        }

        return true;
    }
}