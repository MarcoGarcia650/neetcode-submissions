class Solution {
    public int findMin(int[] nums) {
        // we are looking for the rotation point, which is the minimum value.

        int left = 0;
        int right = nums.length - 1;

        while (left < right){
            int mid = left + (right - left) / 2;

            if(nums[mid] > nums[right]){
                // if mid value is larger that rightmost, rotation pt/ min val is on right half
                left = mid + 1;
            } else {
                // rightmost could be min value
                right = mid;
            }
        }
        return nums[left];
    }
}
