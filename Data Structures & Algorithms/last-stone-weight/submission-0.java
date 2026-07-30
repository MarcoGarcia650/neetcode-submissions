class Solution {
    public int lastStoneWeight(int[] stones) {
        // minHeap
        // add all stones to heap
        // remove top 2 stones
        // do logic
        // return 0 or last stone, if any

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        for(int stone : stones){
            maxHeap.add(stone);
        }

        // keep smashing while 2 stones exist
        while(maxHeap.size() > 1){
            int first = maxHeap.poll();
            int second = maxHeap.poll();

            // if top 2 largest stones equal, it'd add 0; if if statement true, result will be added to heap
            if(first != second){
                maxHeap.add(first - second);
            }
        }

        // returns 0 if the last 2 stones happen to be equal size, else, return the last stone
        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }
}
