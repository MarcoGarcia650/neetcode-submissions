class Solution {
    public int maxProduct(int[] nums) {
        // T: O(n)
        // S: O(1)
        // set min, max, and res to first num
        int currMax = nums[0];
        int currMin = nums[0];
        int res = nums[0];

        for(int i = 1; i < nums.length; i++){
            // get curr num
            int x = nums[i];

            // save prev max
            int prevMax = currMax;

            // calc curr Max; saves the largest possible product
            currMax = Math.max(x, Math.max(x * currMax, x * currMin));

            // calc curr Min; saves the smallest possible product
            currMin = Math.min(x, Math.min(x * prevMax, x * currMin));

            // sets result to largest product
            res = Math.max(res, currMax);
        }
        return res;
    }
}
