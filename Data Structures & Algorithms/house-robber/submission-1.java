class Solution {
    public int rob(int[] nums) {
        // T: O(n)
        // S: O(n)
        // there's a more optimal verson, S: O(n)
        // start backwards, find the most valuable house to rob either by robbing curr hous or skipping
        // this gets the most amount of money to result arr[0]

        if(nums.length == 2) return Math.max(nums[0], nums[1]);
        if(nums.length == 1) return nums[0]; 

        int n = nums.length;
        int[] moneyBag = new int[n];
        int maxRobbed = 0;

        moneyBag[n - 1] = nums[n - 1];
        moneyBag[n - 2] = Math.max(nums[n - 2], nums[n - 1]);

        for(int i = nums.length - 3; i >= 0; i--){
            moneyBag[i] += Math.max(nums[i] + moneyBag[i + 2], moneyBag[i + 1]);
        }
        
        return moneyBag[0];
    }
}
