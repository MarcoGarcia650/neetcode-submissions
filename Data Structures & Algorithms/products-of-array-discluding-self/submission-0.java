class Solution {
    public int[] productExceptSelf(int[] nums) {
        // i: int arr
        // o: int arr
        // edge cases: empty nums
        // strat:
        // running product
        // get running product from left to right, left product
        // store left product in result arr
        // get running product from right to left, right product
        // multiply  existing result[i] by right product
        // return result

        // edge case:
        if(nums.length == 0) return new int[] {};

        int[] result = new int[nums.length];

        int leftProduct = 1;
        for(int i = 0; i < nums.length; i++){
            result[i] = leftProduct;
            leftProduct *= nums[i];
        }

        int rightProduct = 1;
        for(int i = nums.length - 1; i >= 0; i--){
            result[i] *= rightProduct;
            rightProduct *= nums[i];
        }
        return result;
        // Time: O(n), two linear passes
        // Space: O(1) total with two variables, O(n) extra space counting output (not usually done)
    }
}  
