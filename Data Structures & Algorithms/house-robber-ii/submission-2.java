class Solution {
    public int rob(int[] nums) {
        // house robber but run dp on 2 ranges and return max
        // since its circular, moving the start and ending range 1 count gets gets the other max money
        // esentially two sprees possible, return the best money one
        int len = nums.length;

        // nums, start, end
        return Math.max(rob(nums, 1, len - 1), rob(nums, 0, len - 2));

    }

    private int rob(int[] nums, int start, int end){
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);

        int next1 = 0;
        int next2 = 0;

        // starting from house at nums[0]
        for(int i = end; i >= start; i--){
            int curr = Math.max(nums[i] + next2, next1);

            next2 = next1;
            next1 = curr;
        }
        return next1;
    }
}
