class Solution {
    public int singleNumber(int[] nums) {
        // XOR operation
        // set res to 0; if result is XOR to num that matches (dupe), they cancel; when it
        // reaches unique num; res = num until dupe is found or not found and res (num) is returned

        int result = 0;

        for(int num : nums){
            result ^= num;
        }
        return result;
    }
}
