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
    
    private int preIndex = 0;
    private HashMap<Integer, Integer> inorderIndexMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Barney:
        // preorder: root first
        // inorder: left side | root | right side

        // store inorder index for O(1) lookup
        for(int i = 0; i < inorder.length; i++){
            inorderIndexMap.put(inorder[i], i);
        }

        return build(preorder, 0, inorder.length - 1);
    }

    // function to build tree
    private TreeNode build(int[] preorder, int left, int right){
        
        // no nodes in this subtree
        if(left > right) return null;

        // preorder gives us next root
        int rootVal = preorder[preIndex];
        preIndex++;

        TreeNode root = new TreeNode(rootVal);

        // find root position in inorder
        int mid = inorderIndexMap.get(rootVal);

        // everything left of mid belongs to left subtree
        // left and right are boundaries. this means everything left of mid will be built will be built at root.left
        root.left = build(preorder, left, mid - 1);

        // everything right of mid belongs to right subtree
        root.right = build(preorder, mid + 1, right);

        return root;
    }
}
