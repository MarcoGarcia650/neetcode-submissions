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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        
        // both are empty so they match
        if(p == null & q == null) return true;

        // only one is empty, false
        if(p == null || q == null) return false;

        // if values don't match, false
        if(p.val != q.val) return false;

        // recurse on match pairs from each subtree
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
