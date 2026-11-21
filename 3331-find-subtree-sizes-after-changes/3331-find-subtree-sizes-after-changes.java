class Solution {

    public int[] findSubtreeSizes(int[] parent, String s) {

        int n = parent.length;

        List<Integer>[] tree = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            tree[parent[i]].add(i);
        }

        int[] newParent = parent.clone();

        int[] last = new int[26];

        Arrays.fill(last, -1);

        dfs1(0, tree, s, last, newParent);

        List<Integer>[] newTree = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            newTree[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            newTree[newParent[i]].add(i);
        }

        int[] ans = new int[n];

        dfs2(0, newTree, ans);

        return ans;
    }

    public void dfs1(int u, List<Integer>[] tree, String s,
                     int[] last, int[] newParent) {

        int c = s.charAt(u) - 'a';

        int prev = last[c];

        if (prev != -1) {
            newParent[u] = prev;
        }

        last[c] = u;

        for (int v : tree[u]) {
            dfs1(v, tree, s, last, newParent);
        }

        // Restore previous ancestor
        last[c] = prev;
    }
    public int dfs2(int u, List<Integer>[] tree, int[] ans) {

        ans[u] = 1;

        for (int v : tree[u]) {
            ans[u] += dfs2(v, tree, ans);
        }

        return ans[u];
    }
}