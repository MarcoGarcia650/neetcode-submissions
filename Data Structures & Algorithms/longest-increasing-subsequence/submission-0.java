class Solution {
    public int lengthOfLIS(int[] nums) {
        // T: O(n^2)
        // S: O(n)
        int[] dp = new int[nums.length];

        Arrays.fill(dp, 1);

        int maxLen = 1;

        for(int i = 0; i < nums.length; i++){
            // this makes j check ev everything before i
            for(int j = 0; j < i; j++){
                // if nums[j] is smaller, nums[i] can extend j's LIS
                if(nums[j] < nums[i]){
                    // keep current LIS at i OR extend LIS ending at j by 1
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }
}
