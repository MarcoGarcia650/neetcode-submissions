class Solution {
    public int leastInterval(char[] tasks, int n) {
        // T: O(T) total intervals including idle time
        // S: O(1) 
        
        // count freqs of chars aka tasks
        int[] count = new int[26];
        for(char task : tasks){
            count[task - 'A']++;
        }

        // stores task counts ready to run right now
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);

        for(int freq : count){
            if(freq > 0){
                maxHeap.offer(freq);
            }
        }

        // stores task cooling down: [remainingCount, timeAvailable]
        Queue<int[]> queue = new LinkedList<>();

        int time = 0;

        while(!maxHeap.isEmpty() || !queue.isEmpty()){
            time++;

            // if any cooled task is ready, move it to heap
            if(!queue.isEmpty() && queue.peek()[1] == time){
                maxHeap.offer(queue.poll()[0]);
            }

            // if heap has available task, run it
            if(!maxHeap.isEmpty()){

                int remaining = maxHeap.poll();
                // use this task once
                remaining--;

                // if task still has copies left, put it in cooldown
                if(remaining > 0){
                    queue.offer(new int[]{remaining, time + n + 1});
                }
            }
            // if heap was empty, this time unit was idle
            // we still counted with time++
        }
        return time;
    }
}
