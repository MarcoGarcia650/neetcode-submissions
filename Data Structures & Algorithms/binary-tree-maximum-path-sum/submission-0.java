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
    // Each node updates the best full path through itself, 
    // but returns only its best one-branch path upward.

    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;   
    }

    private int dfs(TreeNode node){
        if(node == null) return 0;

        // get the best path from left/ right, but ignore any negative paths
        int leftGain = Math.max(0, dfs(node.left));
        int rightGain = Math.max(0, dfs(node.right));

        // best path through this node
        int pathThroughNode = leftGain + rightGain + node.val;

        // update max path sum if the one we just saw throguh this node is larger than prev
        maxSum = Math.max(pathThroughNode, maxSum);
        
        // only return the largest path up to the parent
        return node.val + Math.max(leftGain, rightGain);
    }
}
