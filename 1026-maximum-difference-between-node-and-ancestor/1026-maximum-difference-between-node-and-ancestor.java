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
    public int maxAncestorDiff(TreeNode root) {
        return solve(root,Integer.MAX_VALUE,root.val);
    }

    public int solve(TreeNode root, int min , int max){
        if(root == null){
            return 0;
        }
        int diff = 0;
        if(min != Integer.MAX_VALUE){
            diff = Math.abs(root.val - min);
        }
        
        diff = Math.max(diff,Math.abs(root.val - max));

        max = Math.max(max, root.val);
        min = Math.min(min,root.val);
        
        int left = solve(root.left ,min, max);
        int right = solve(root.right , min ,max);
        
        return Math.max(diff,Math.max(left,right));
    }
}