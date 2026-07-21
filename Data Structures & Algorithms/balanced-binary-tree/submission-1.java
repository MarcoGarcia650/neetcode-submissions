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
        public boolean isBalanced(TreeNode root) {
        // checks if we ever found an unbalanced tree
        return height(root) != -1;
    }

    private int height(TreeNode root){
        if(root == null) return 0;

        // checks for unbalanced trees to the left and then right
        int leftHeight = height(root.left);
        if(leftHeight == -1) return -1;

        int rightHeight = height(root.right);
        if(rightHeight == -1) return -1;

        // actual checker to determine if tree is unbalanced
        if(Math.abs(leftHeight - rightHeight) > 1){
            return -1;
        }

        // returns the height of tallest child so checkers above can see if unbalanced
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
