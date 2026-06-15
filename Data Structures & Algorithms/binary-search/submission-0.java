class Solution {
    public int search(int[] nums, int target) {
        // binary search
        // strat:
        // 3 ptrs: left, right, and mid
        // use mid to see relation to target, and left/ right as adjustable bounds
        // return mid if equal to target or -1
        // for Search Insert Positio, return left(where target would be if not found in arr)

        int left = 0;
        int right = nums.length - 1;

        while(left <= right){
            int mid = left + (right - left) / 2;

            if(nums[mid] == target){
                return mid;
            } else if (nums[mid] < target){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;

        
    }
}
