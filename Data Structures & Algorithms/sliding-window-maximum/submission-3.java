class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        // there are nums.length - k + 1 total windows; store the maximum from each window here
        int[] result = new int[nums.length - k + 1];

        // stores indexes with deque; the vals at those indexes stay in decreasing order; front always points to curr win amx
        Deque<Integer> deque = new ArrayDeque<>();

        // next open position in the result array
        int resultIndex = 0;

        for (int right = 0; right < nums.length; right++) {

            // while deque is not empty and leftmost deque index is smaller than current window index beginning; 
            // remove that index as its outside of curr window
            while (!deque.isEmpty()
                    && deque.peekFirst() < right - k + 1) {
                deque.pollFirst();
            }

            // While the deque is not empty and the value at the back
            // is smaller than the new value, remove that back index;
            // It can never become a future maximum because the new value
            // is larger and will stay in the window longer
            while (!deque.isEmpty()
                    && nums[deque.peekLast()] < nums[right]) {
                deque.pollLast();
            }

            // Add the current index to the back b/c it's largest in window
            deque.offerLast(right);

            // A complete window first exists when right reaches k - 1
            if (right >= k - 1) {
                // Front index always points to the largest value in the window
                result[resultIndex] = nums[deque.peekFirst()];
                resultIndex++;
            }
        }

        return result;
        // T: O(n)
        // S: O(k) 
    }
}