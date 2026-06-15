class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // hashing
        // heap
        // i: array of int, int
        // o: arr of int
        // edge cases: nums is emtpy or k is 0, return empty result before algo runs
        // strat: 
        // use hashmap to build freq of nums
        // use arraylist to build result
        // use min heap to get k most freq elements
        
        HashMap<Integer, Integer> map = new HashMap<>();
        // num,  freq

        // build result arr at size k
        int[] result = new int[k];


        // edge case
        if(nums.length == 0 || k == 0) return result;

        // build freq table
        for(int i = 0; i < nums.length; i++){
            int curr = nums[i];

            map.put(curr, map.getOrDefault(curr, 0 ) + 1);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> map.get(a) - map.get(b));
        
        // put k amount of map keys into min heap
        for(int num : map.keySet()){
            minHeap.offer(num);

            if(minHeap.size() > k){
                minHeap.poll();
            }
        }

        // fill result arr
        for(int i = k - 1; i >= 0; i--){
            result[i] = minHeap.poll();
        }

        return result;
    }
}
