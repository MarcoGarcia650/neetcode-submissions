class MedianFinder {

    private PriorityQueue<Integer> small; // maxHeap; holds top of small half
    private PriorityQueue<Integer> large; // minHeap; holds bottom of top half

    public MedianFinder() {
        small = new PriorityQueue<>(Comparator.reverseOrder());
        large = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        // first add num to smaller half
        small.offer(num);

        // if biggest val in small is > the smallest in large and large isnt empty, move the val right
        if(!large.isEmpty() && small.peek() > large.peek()){
            large.offer(small.poll());
        }

        // if small has too many numbers, move biggest to large half; itll be new large bottom
        if(small.size() > large.size() + 1){
            large.offer(small.poll());
        }

        // vice versa
        if(small.size() < large.size()){
            small.offer(large.poll());
        }
    }
    
    public double findMedian() {
        // odd num of values: small has 1 extra, top is median
        if(small.size() > large.size()){
            return small.peek();
        }

        // even: take the average
        return (small.peek() + large.peek()) / 2.0;
    }
}
