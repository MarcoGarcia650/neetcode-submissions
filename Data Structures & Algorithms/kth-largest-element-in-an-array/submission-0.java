class Solution {
    public int findKthLargest(int[] nums, int k) {
        // minHeap
        // add all num to heap; while heap size greater than k, poll (removes smallest); return

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int num : nums){
            minHeap.add(num);
        }

        while(minHeap.size() > k){
            minHeap.poll();
        }

        return minHeap.peek();
    }
}
