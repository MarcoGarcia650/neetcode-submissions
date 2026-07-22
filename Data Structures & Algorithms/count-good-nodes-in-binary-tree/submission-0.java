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
        return dfs(root, Integer.MIN_VALUE);
    }

    private int dfs(TreeNode node, int maxSoFar){
        if(node == null) return 0;

        int count = 0;

        // if curr node is good node, start count
        if(node.val >= maxSoFar){
            count = 1;
        }

        // update max so next nodes can compare to max seen so far
        maxSoFar = Math.max(maxSoFar, node.val);

        // recurse on children and increment count for any more good nodes found
        count += dfs(node.left, maxSoFar);
        count += dfs(node.right, maxSoFar);

        return count;
    }
}
