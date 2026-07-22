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
    public boolean isValidBST(TreeNode root) {
        // recursively check that every node stays within the min/max range created by its ancestors
        // T: O(n)
        // S: O(h), O(n) skinny tree, O(log n) for balanced tree

        return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean valid(TreeNode node, long min, long max){
        if(node == null) return true;

        if(node.val <= min || node.val >= max) return false;

        return valid(node.left, min, node.val) && valid(node.right, node.val, max);
    }
}
