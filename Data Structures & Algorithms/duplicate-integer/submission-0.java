class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer, Integer> seen = new HashMap();
        for (int i = 0; i < nums.length; i++){
            int s = nums[i];

            if (seen.containsKey(s)){
                return true;
            }
            seen.put(s, 1);
        }
        return false;
    }
}