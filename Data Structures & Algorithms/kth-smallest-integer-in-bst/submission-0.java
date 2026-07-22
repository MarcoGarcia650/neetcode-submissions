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
    public int kthSmallest(TreeNode root, int k) {
        // dfs, iterative stack; recursion doing too ie dfs and count
        
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while(curr != null || !stack.isEmpty()){
            
            // add elements from largest to smallest, going deep left
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }
        
            // start removing largest elements and decrementing k
            curr = stack.pop();
            k--;

            // when k hits 0, found kth smallest int
            if(k == 0) return curr.val;

            // if not found on left, start going down right side of root
            curr = curr.right;
        }
        return -1;
    }
}
