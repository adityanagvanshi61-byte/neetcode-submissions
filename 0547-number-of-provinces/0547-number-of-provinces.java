class Solution {

    public void dfs(int i, ArrayList<ArrayList<Integer>> adj, int[] vis) {
        vis[i] = 1;

        for (int j : adj.get(i)) {
            if (vis[j] == 0) {
                dfs(j, adj, vis);
            }
        }
    }

    public int findCircleNum(int[][] V) {
        int n = V.length;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Convert adjacency matrix to adjacency list
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // ERROR FIX: Check V[i][j], not adj.get(i).get(j)
                if (V[i][j] == 1 && i != j) {
                    adj.get(i).add(j);
                }
            }
        }

        int[] vis = new int[n];
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                cnt++;
                dfs(i, adj, vis);
            }
        }

        return cnt;
    }
}