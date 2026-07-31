class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // max Heap
        // heap stores all the pts, so 1d arrs. itll keep only the kth closest pts
        // build result 2d arr size k,2 after heap is done, add all pts to result arr
        // new distance function will be used to pass to PQ Constructor so it knows the order of the pts

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> distance(b) - distance(a));

        for(int[] point : points){
            maxHeap.offer(point);

            if(maxHeap.size() > k){
                maxHeap.poll();
            }
        }
        int[][] result = new int[k][2];

        for(int i = 0 ; i < k; i++){
            result[i] = maxHeap.poll();
        }
        return result;
    }

    private int distance(int[] point){
        int x = point[0];
        int y = point[1];

        // sqrt not needed, this op shows already shows largest 
        return x * x + y * y;
    }
}
