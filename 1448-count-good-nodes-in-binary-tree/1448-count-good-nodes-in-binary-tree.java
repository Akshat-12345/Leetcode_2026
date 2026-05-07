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
    public int goodNodes(TreeNode root) {
        return solve(root,root.val);
    }

    public int solve(TreeNode root , int maxVal){
        if(root == null){
            return 0;
        }
        int ans = 0;

        if(root.val >= maxVal){
            ans++;
        }
        
        maxVal = Math.max(maxVal,root.val);

        ans += solve(root.left,maxVal);
        ans += solve(root.right,maxVal);

        return ans;

    }
}