class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];

        Deque<Integer> deque = new ArrayDeque<>();

        int resultIndex = 0;

        for(int right = 0; right < nums.length; right++){

            while(!deque.isEmpty() && deque.peek() < right - k + 1){
                deque.pollFirst();
            }

            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[right]){
                deque.pollLast();
            }

            deque.offerLast(right);

            if(right >= k - 1){
                result[resultIndex] = nums[deque.peekFirst()];
                resultIndex++;
            }
        }
        return result;
    }
}
