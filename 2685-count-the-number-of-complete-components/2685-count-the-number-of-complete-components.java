import java.util.*;

class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] degree = new int[n];
        
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
            degree[u]++;
            degree[v]++;
        }
        
        boolean[] visited = new boolean[n];
        int completeComponentsCount = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (bfsCheckComplete(i, adj, degree, visited)) {
                    completeComponentsCount++;
                }
            }
        }
        
        return completeComponentsCount;
    }
    
    private boolean bfsCheckComplete(int start, List<List<Integer>> adj, int[] degree, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> componentNodes = new ArrayList<>();
        
        queue.offer(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            componentNodes.add(curr);
            
            for (int neighbor : adj.get(curr)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }
        int totalNodes = componentNodes.size();
        for (int node : componentNodes) {
            if (degree[node] != totalNodes - 1) {
                return false;
            }
        }
        
        return true;
    }
}