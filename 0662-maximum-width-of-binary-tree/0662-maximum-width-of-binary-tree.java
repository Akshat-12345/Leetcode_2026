/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    class pair{
        TreeNode node;
        int idx;
        public pair(TreeNode node, int idx){
            this.node = node;
            this.idx = idx;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(root,0));
        int maxLen = 0;

        while(!q.isEmpty()){
           int size = q.size();
           int l = 0;
           int r = 0;
           for(int i = 0 ; i < size ; i++){
               pair curr = q.remove();
                if(i == 0){
                  l = curr.idx;
                }
 
                if(i == size -1){
                  r = curr.idx;
                }

                if(curr.node.left != null){
                    q.add(new pair(curr.node.left, 2 * curr.idx + 1));
                }

                if(curr.node.right != null){
                    q.add(new pair(curr.node.right, 2 * curr.idx + 2));
                }
           }
           
           maxLen = Math.max(maxLen, r - l + 1);
        }

        return maxLen;
    }
}