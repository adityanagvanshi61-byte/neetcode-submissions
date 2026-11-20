class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        zigzag(root, ans);
        return ans;
    }

    public void zigzag(TreeNode root, List<List<Integer>> ans) {
        if (root == null) return;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean leftToRight = true;

        while (!q.isEmpty()) {
            List<Integer> z = new ArrayList<>();
            int n = q.size();

            for (int i = 0; i < n; i++) {
                TreeNode curr = q.poll();

                z.add(curr.val);

                if (curr.left != null)
                    q.add(curr.left);

                if (curr.right != null)
                    q.add(curr.right);
            }

            if (!leftToRight)
                Collections.reverse(z);

            ans.add(z);
            leftToRight = !leftToRight;
        }
    }
}