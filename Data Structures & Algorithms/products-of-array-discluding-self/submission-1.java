class Solution {
    public int[] productExceptSelf(int[] nums) {
        // i: int arr
        // o: int arr
        // arrays
        // strat:
        // get leftProduct; rightProduct
        // sweep left to right for leftP
        // sweep right to left for rightP
        // add together, fill into result arr

        int[] result = new int[nums.length]; 
        int leftProduct = 1;
        int rightProduct = 1;

        // leftProduct
        for(int i = 0; i < nums.length; i++){
            result[i] = leftProduct;
            leftProduct *= nums[i];
        }
        
        // rightProduct
        for(int i = nums.length - 1; i >= 0; i--){
            result[i] *= rightProduct;
            rightProduct *= nums[i];
        }
        return result;
    }
}  
