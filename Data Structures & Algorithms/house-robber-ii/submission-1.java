class Solution {
    public int rob(int[] nums) {
        // house robber but run dp on 2 ranges and return max
        // since its circular, moving the start and ending range 1 count gets gets the other max money
        // esentially two sprees possible, return the best money one

        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);

        int next1 = 0;
        int next2 = 0;

        int maxMoney = 0;

        // starting from house at nums[0]
        for(int i = nums.length - 2; i >= 0; i--){
            int curr = Math.max(nums[i] + next2, next1);

            next2 = next1;
            next1 = curr;
        }
        maxMoney = next1;
        next2 = 0;
        next1 = 0;

        for(int i = nums.length - 1; i >= 1; i--){
            int curr = Math.max(nums[i] + next2, next1);

            next2 = next1;
            next1 = curr;
        }
        maxMoney = Math.max(maxMoney, next1);
        return maxMoney;
    }
}
