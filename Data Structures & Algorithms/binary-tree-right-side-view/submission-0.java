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
    public List<Integer> rightSideView(TreeNode root) {
        // BFS, Queue
        // we are going to add all nodes to the queue level by level, left nodes first, and record level size
        // then, as we loop through adding more children, once we hit end of level size, we found rightmost
        // add to result arr and remove from queue; queue now only has children and ready for next loop
        // loops back through loop
        // T: O(n)
        // S: O(n)

        List<Integer> result = new ArrayList<>();
        
        if(root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        // level order traversal/ bfs
        while(!q.isEmpty()){

            // numm of nodes at this level
            int size = q.size();
            
            for(int i = 0; i < size; i++){
                TreeNode node = q.poll();

                // if this is last node in level, it is rightmost, add to result arr list
                if(i == size - 1){
                    result.add(node.val);
                }

                // add children for next level search
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
        }
        return result;
    }
}
