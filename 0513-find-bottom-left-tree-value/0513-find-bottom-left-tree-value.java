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
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        TreeNode prev = null;
        while(!q.isEmpty()){        
            prev = q.peek();
            int size = q.size();
                for(int i = 0; i < size; i++){
                     TreeNode curr = q.remove();
                     if(curr.left != null){
                           q.add(curr.left);
                      }
                      if(curr.right != null){
                         q.add(curr.right);
                      }
                }
        }
        return prev.val;
    }
}