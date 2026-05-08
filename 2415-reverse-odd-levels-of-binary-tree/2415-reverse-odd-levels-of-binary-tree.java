class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int level = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            ArrayList<TreeNode> curr = new ArrayList<>();

            for (int i = 0; i < size; i++) {

                TreeNode node = q.poll();
                curr.add(node);

                if (node.left != null) {
                    q.offer(node.left);
                }

                if (node.right != null) {
                    q.offer(node.right);
                }
            }

            // odd level reverse
            if (level % 2 == 1) {

                int left = 0;
                int right = curr.size() - 1;

                while (left < right) {

                    int temp = curr.get(left).val;
                    curr.get(left).val = curr.get(right).val;
                    curr.get(right).val = temp;

                    left++;
                    right--;
                }
            }

            level++;
        }

        return root;
    }
}