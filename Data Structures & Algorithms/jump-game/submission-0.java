class Solution {
    public boolean canJump(int[] nums) {
        // T: O(n)
        // S: O(1)
        int maxReach = 0;

        for(int i = 0; i < nums.length; i++){
            // cant reach this index
            if(i > maxReach){
                return false;
            }
            
            // update farthest we can reach
            maxReach = Math.max(maxReach, i + nums[i]);

            // we can reach last index
            if(maxReach >= nums.length - 1){
                return true;
            }
        }
        return true;
    }
}
