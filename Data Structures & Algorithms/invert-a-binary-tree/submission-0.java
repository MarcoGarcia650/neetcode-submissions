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
    public TreeNode invertTree(TreeNode root) {
        // null check
        if(root == null) return null;

        // save left node in temp node
        TreeNode temp = root.left;
        // swap ptrs
        root.left = root.right;
        // pt right to saved original left ndoe
        root.right = temp;  

        // recurse on both left and right node
        invertTree(root.left);
        invertTree(root.right);

        return root;

        // T: O(n) visit every node
        // S:   O(h) tree height
        //      shaped like linked list: O(n)
        //      shaped like balanced tree: O(log n) 
    }
}
