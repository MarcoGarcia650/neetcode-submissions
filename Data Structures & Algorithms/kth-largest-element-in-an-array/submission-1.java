class Solution {
    public int findKthLargest(int[] nums, int k) {
        // minHeap
        // add all num to heap; when heap size greater than k, poll (removes smallest); return

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int num : nums){
            minHeap.add(num);

            if(minHeap.size() > k){
                minHeap.poll();
            }
        }

        return minHeap.peek();
    }
}
