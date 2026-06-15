class Solution {
    public int search(int[] nums, int target) {
        // binary search
        // strat: 3 ptrs; left, right, mid
        // one half a rotated sorted array will always be ascending
        // check if that validated sorted half has target, if yes, do regular binary search
        // if not, check the other half and redo above process

        int left = 0;
        int right = nums.length - 1;

        while(left <= right){
            // mid must be declared in while loop so it is always updated
            int mid = left + (right - left) / 2;

            if(nums[mid] == target) return mid;

            // bottom half
            if(nums[left] <= nums[mid]){
                if(nums[left] <= target && target < nums[mid]){
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
                // top half
            } else {
                if (nums[mid] < target && target <= nums[right]){
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
        
    }
}
