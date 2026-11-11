class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {

        int n = graph.length;

        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[n];

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Reverse the graph
        for (int i = 0; i < n; i++) {
            for (int v : graph[i]) {
                adj.get(v).add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        // Terminal nodes
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        List<Integer> ans = new ArrayList<>();

        // BFS
        while (!q.isEmpty()) {
            int node = q.poll();
            ans.add(node);

            for (int v : adj.get(node)) {
                indegree[v]--;

                if (indegree[v] == 0) {
                    q.add(v);
                }
            }
        }

        Collections.sort(ans);
        return ans;
    }
}