class KthLargest {
    private int k;
    private PriorityQueue<Integer> minHeap;

    // Constructor T: O(n log k)
    public KthLargest(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>();

        // add each starting num through add()
        // add will keep head size at k
        for(int num : nums){
            add(num);
        }
    }
    
    // T: O(log k)
    public int add(int val) {
        // add new val to heap
        minHeap.offer(val);

        // if heap. size > k, remove smallest
        if(minHeap.size() > k){
            minHeap.poll();
        }

        // returns kth largest element per reqs
        return minHeap.peek();
    }

    // S: O(k)
}
