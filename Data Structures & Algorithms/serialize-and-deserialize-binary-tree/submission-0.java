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

public class Codec {
    // we'll do preorder traversal to ser and deser
    // need to build both dfs functions
    // comma will be delimiter

    // will track where deserialized string val should go in tree
    private int index;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfsSerialize(root, sb);
        return sb.toString();
    }

    // serialize using preorder dfs
    private void dfsSerialize(TreeNode node, StringBuilder sb){
        if(node == null) {
            sb.append("N,");
            return;
        }

        // , is delimiter
        sb.append(node.val).append(",");
        // preorder so left goes first
        dfsSerialize(node.left, sb);
        dfsSerialize(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] values = data.split(",");
        // start index at 0
        index = 0;
        return dfsDeserialize(values);
    }

    // deserialize using preorder
    private TreeNode dfsDeserialize(String[] values){
        // value at index
        String value = values[index];
        // increment index
        index++;

        if(value.equals("N")){
            return null;
        }

        // if not null, make new node
        TreeNode node = new TreeNode(Integer.parseInt(value));

        // run dfs deser o both sides and recursively attach any other valid nodes, preorder
        node.left = dfsDeserialize(values);
        node.right = dfsDeserialize(values);

        return node;
    }
}
