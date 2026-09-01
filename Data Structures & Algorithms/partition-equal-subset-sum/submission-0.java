class Solution {
    public boolean canPartition(int[] nums) {
        // T: O(n * target)
        // S: O(target)
        int sum = 0;

        for(int num : nums){
            sum += num;
        }

        if(sum % 2 != 0) return false; // sum must be even because int arr

        int target = sum / 2;

        boolean[] dp = new boolean[target + 1];
        dp[0] = true; // we know sum 0 possible by doing nothing

        for(int num : nums){
            //  going backwards ensures num only used once
            for(int t = target; t >= num; t--){
                // T if t already true or remainder can be made ie 6 - 5 = 1 which is true, so 6 true too
                dp[t] = dp[t] || dp[t - num];
            }
        }
        return dp[target];
    }
}
