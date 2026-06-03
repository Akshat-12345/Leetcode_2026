/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public boolean solve(TreeNode root, TreeNode p , ArrayList<TreeNode> path){
        if(root == null){
            return false;
        }

        path.add(root);

        if(root.val == p.val){
            return true;
        }

        boolean l = solve(root.left, p , path);
        boolean r = solve(root.right, p , path);

        boolean ans = l || r;

        if(!ans){
            path.remove(path.size() - 1);
            return false;
        }
        return true;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> path1 = new ArrayList<>();
        ArrayList<TreeNode> path2 = new ArrayList<>();

        solve(root,p,path1);
        solve(root,q,path2);

        int n = path1.size();
        int m = path2.size();
        
        int i = 0; 
        TreeNode curr = null;
        while(i < n && i < m){
           if(path1.get(i) != path2.get(i)){
              break;
           }

           curr = path1.get(i);  
           i++;
        }

        return curr;
    }
}