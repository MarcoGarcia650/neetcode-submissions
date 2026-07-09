class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        // There are nums.length - k + 1 total windows.
        // Store the maximum from each window here.
        int[] result = new int[nums.length - k + 1];

        // Stores indexes, not values.
        // The values at those indexes stay in decreasing order,
        // so the front always points to the current window's maximum.
        Deque<Integer> deque = new ArrayDeque<>();

        // Next open position in the result array.
        int resultIndex = 0;

        for (int right = 0; right < nums.length; right++) {

            // Current window starts at: right - k + 1.
            // Remove the front index if it is left of the current window.
            while (!deque.isEmpty()
                    && deque.peekFirst() < right - k + 1) {
                deque.pollFirst();
            }

            // Remove indexes from the back whose values are smaller
            // than the new value. They can never become a future maximum
            // because the new value is larger and will remain in the window longer.
            while (!deque.isEmpty()
                    && nums[deque.peekLast()] < nums[right]) {
                deque.pollLast();
            }

            // Add the current index to the back.
            deque.offerLast(right);

            // A complete window first exists when right reaches k - 1.
            if (right >= k - 1) {
                // Front index always points to the largest value in the window.
                result[resultIndex] = nums[deque.peekFirst()];
                resultIndex++;
            }
        }

        return result;
    }
}