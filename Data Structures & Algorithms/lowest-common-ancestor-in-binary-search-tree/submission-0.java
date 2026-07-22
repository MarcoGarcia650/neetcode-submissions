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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // this is BST, so doesnt work for 236 lCA BT
        
        // if both targets are smaller, go left. if both larger, go right. if they split, current root 
        // is LCA

        while(root != null){

            if(p.val < root.val && q.val < root.val){
                root = root.left;
            } else if (p.val > root.val && q.val > root.val){
                root = root.right;
            } else {
                return root;
            }
        }
        return null;
    }
}
