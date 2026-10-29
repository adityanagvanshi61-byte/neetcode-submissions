import java.util.*;

class Solution {
    private List<Integer>[] adj;
    private int[] tin, tout;
    private int timer;
    private int[][] up;
    private int[] depth;
    private int LOG;
    private int[] bit;
    private int m;

    private void add(int i, int delta) {
        for (; i <= m; i += i & -i) {
            bit[i] ^= delta;
        }
    }

    private void rangeXor(int l, int r, int delta) {
        add(l, delta);
        add(r + 1, delta);
    }

    private int queryBit(int i) {
        int sum = 0;
        for (; i > 0; i -= i & -i) {
            sum ^= bit[i];
        }
        return sum;
    }

    private void dfs(int u, int p, int d) {
        tin[u] = ++timer;
        up[u][0] = p;
        depth[u] = d;

        for (int i = 1; i < LOG; i++) {
            up[u][i] = up[up[u][i - 1]][i - 1];
        }

        for (int v : adj[u]) {
            if (v != p) {
                dfs(v, u, d + 1);
            }
        }
        tout[u] = timer;
    }

    private int getLca(int u, int v) {
        if (depth[u] < depth[v]) {
            int tmp = u;
            u = v;
            v = tmp;
        }

        for (int k = LOG - 1; k >= 0; k--) {
            if (depth[u] - (1 << k) >= depth[v]) {
                u = up[u][k];
            }
        }

        if (u == v) return u;

        for (int k = LOG - 1; k >= 0; k--) {
            if (up[u][k] != up[v][k]) {
                u = up[u][k];
                v = up[v][k];
            }
        }
        return up[u][0];
    }

    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }

        LOG = 1;
        while ((1 << LOG) <= n) LOG++;

        tin = new int[n];
        tout = new int[n];
        timer = 0;
        up = new int[n][LOG];
        depth = new int[n];

        dfs(0, 0, 0);

        m = n + 2;
        bit = new int[m + 2];

        int[] charVal = new int[n];
        for (int i = 0; i < n; i++) {
            charVal[i] = 1 << (s.charAt(i) - 'a');
            rangeXor(tin[i], tout[i], charVal[i]);
        }

        List<Boolean> ans = new ArrayList<>();

        for (String q : queries) {
            if (q.startsWith("update")) {
                String[] parts = q.split(" ");
                int u = Integer.parseInt(parts[1]);
                char c = parts[2].charAt(0);

                int oldVal = charVal[u];
                int newVal = 1 << (c - 'a');
                int diff = oldVal ^ newVal;

                charVal[u] = newVal;
                rangeXor(tin[u], tout[u], diff);
            } else {
                String[] parts = q.split(" ");
                int u = Integer.parseInt(parts[1]);
                int v = Integer.parseInt(parts[2]);

                int lca = getLca(u, v);

                int maskU = queryBit(tin[u]);
                int maskV = queryBit(tin[v]);
                int pathMask = maskU ^ maskV ^ charVal[lca];

                // At most one bit set means path characters can form a palindrome
                ans.add((pathMask & (pathMask - 1)) == 0);
            }
        }

        return ans;
    }
}