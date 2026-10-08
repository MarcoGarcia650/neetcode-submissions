/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    private HashMap<Node, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        // DFS
        // T: O(V + E) visit each vertex is cloned once, neighbors visited once
        // S: O(V) clone of orginal graph and neighbhors lists
        return dfs(node);
    }

    private Node dfs(Node node){
        if(node == null) return null;

        if(map.containsKey(node)){
            return map.get(node);
        }

        Node copy = new Node(node.val);
        map.put(node, copy);

        // dfs under here
        for(int i = 0; i < node.neighbors.size(); i++){
            copy.neighbors.add(dfs(node.neighbors.get(i)));
        }
        // return copied node after dfs
        return copy;
    }
}