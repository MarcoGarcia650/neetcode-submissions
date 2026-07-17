class LRUCache {

    // input: new lru cache, capacity, get or put method, key, value
    // hash map and doubly linked list
    // hash map for O(1) lookup
    // hash key: same as the input
    // hash value: ptr to node itself
    // left and right ptr dummy nodes: left is least recently used; right is most
    // when we put another val breaking capacity, we remove the least used and update list to make new 
    // put the most used

    public class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    private int capacity;
    private HashMap<Integer, Node> map;
    private Node left;
    private Node right;
    

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();

        // dummy bounds
        left = new Node(0, 0);
        right = new Node(0, 0);

        left.next = right;
        right.prev = left;
    }

    // remove node from wherever it is currently
    private void remove(Node node){
        // saving nodes immediately next to node being removed
        Node prevNode = node.prev;
        Node nextNode = node.next;

        // sets prev node next ptr to skip over curr node
        prevNode.next = nextNode;
        // sets next nodes prev ptr to skip over curr node
        nextNode.prev = prevNode;
        // essentially gets the nodes bounder node's ptrs to jump over it
    }

    // insert new node to the front before dummy right bound as its now most recent used
    private void insert(Node node){
        // saving rightmost valid node
        Node prevNode = right.prev;
        // saving boundary
        Node nextNode = right;

        // adds new node to end of valid last node
        prevNode.next = node;
        // pts new valid node prev ptr back to previous valid last node
        node.prev = prevNode;

        // sets new valid most used node ptr to boundary
        node.next = nextNode;
        //pts boundary prev ptr back to new valid node
        nextNode.prev = node;
    }


    public int get(int key) {
        if(!map.containsKey(key)){
            // problem req
            return -1;
        }

        // if its there, move its place in cache and return value
        Node node = map.get(key);

        remove(node);
        insert(node);

        return node.value;
    }
    
    public void put(int key, int value) {

        if(map.containsKey(key)){
            // remove old node before replacing it
            remove(map.get(key));
        }

        Node node = new Node(key, value);
        map.put(key, node);
        insert(node);

        if(map.size() > capacity){
            // remove LRU valid node
            Node lru = left.next;
            remove(lru);
            map.remove(lru.key);
        }
    }
}
