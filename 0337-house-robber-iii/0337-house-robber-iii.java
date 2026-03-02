class Solution {
    Map<TreeNode, Integer> dp = new HashMap<>();

    public int rob(TreeNode root) {
        if (root == null) return 0;
        if (dp.containsKey(root)) return dp.get(root);

        int take = root.val;

        if (root.left != null) {
            take += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            take += rob(root.right.left) + rob(root.right.right);
        }

        int skip = rob(root.left) + rob(root.right);

        int ans = Math.max(take, skip);
        dp.put(root, ans);
        return ans;
    }
}