/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        // need hashmap to first copy nodes because random points anywhere therefore cannot create/
        // list in one pass as you cannot point to a node that doesn't exist yet

        HashMap<Node, Node> map = new HashMap<>();

        Node curr = head;

        // create copy nodes that pair to original node
        while(curr != null){
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        curr = head;

        // connect next and random ptrs to copies
        while(curr != null){
            Node copy = map.get(curr);

            copy.next = map.get(curr.next);
            copy.random = map.get(curr.random);

            curr = curr.next;
        }

        return map.get(head);

        // T: O(n)
        // S: O(n)
    }
}
