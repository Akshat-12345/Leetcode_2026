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
    public boolean path(TreeNode root , TreeNode p , ArrayList<TreeNode> path){
        if(root == null){
            return false;
        }

        path.add(root);

        if(root == p){
            return true;
        }

        boolean left = path(root.left , p , path);
        boolean right = path(root.right, p , path);

        boolean ans = left || right;

        if(!ans){
            path.remove(path.size() - 1);
            return false;
        }

        return true;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> path1 = new ArrayList<>();
        ArrayList<TreeNode> path2 = new ArrayList<>();

        path(root,p, path1);
        path(root,q,path2);

        int i = 0; 

        while(i < path1.size() && i < path2.size()){
            if(path1.get(i) != path2.get(i)){
                break;
            }
            i++;
        }

        return path1.get(i-1);
    }
}