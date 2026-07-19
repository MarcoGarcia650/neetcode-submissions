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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // empty tree is always a subtree
        if(subRoot == null)
            return true;

        // if root empty but subtree not, subtree cannot be found there
        if(root == null)
            return false;

        // if the tree starting at this root matches subRoot, we found the subtree
        if(isSameTree(root, subRoot))
            return true;

        // if else, recurse on both sides and return if subtree has been found
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSameTree(TreeNode p, TreeNode q) {
        // if both trees null, true
        if(p == null && q == null)
            return true;
        
        // if only one is null, false
        if(p == null || q == null)
            return false;

        // if vals dont match, false
        if(p.val != q.val)
            return false;

        // recurse on matching children pairs
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
