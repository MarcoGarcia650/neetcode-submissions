class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // we are finding the slowest rate of eating within time allotment of h for all banana piles
        // so we'll binary search on eating speeds
        // left (slowest) is 1, right is largest possible speed--which is largest possible pile size
        // regular binary search on this speed window
        // if answer works, maybe it can go slower,
        // if too slow and exceeds the hour time limit, increase banana eating rate

        int left = 1;   
        int right = 0;

        // setting fast speed in window to largest pile size
        for(int pile : piles){
            right = Math.max(right, pile);
        }
        int answer = right;

        while(left <= right){
            int mid = left + (right - left) / 2;

            // hours long because answer may be too large for int else risk overflow
            long hours = 0;

            // 
            for(int pile : piles){
                // adding speed so java int division rounds to actual hours needed, else itll round down
                // ie pile. = 7; k = 3; needs 3 hours; w/o adding speed, rounds to 2
                hours += (pile + mid - 1) / mid;
            }

            // if hours is within valid time window; update answer (as it's slower than largest pile 
            // therefore usuable rate), and check for slower rate
            if(hours <= h){
                answer = mid;
                right = mid - 1;
            } else {
                // if curr rate is too slow, shrink window of speeds
                left = mid + 1;
            }
        }
        return answer;
    }
}
