class Solution {
    public int longestConsecutive(int[] nums) {
        // hashing
        // num
        // iterate through nums and add to set
        // iterate through nums in set
        // if nums[i]  - 1 NOT seen before in set, this is will be a start of a seq
        // start length tracker, while nums[i] + 1 DOES exist in set, update counter
        // update max length, return it
        // Time: O(n), one linear pass through nums and set each
        // Space: O(n), size of set

        HashSet<Integer> set = new HashSet<>();

        int maxLen = 0;

        for(int num : nums){
            set.add(num);
        }

        for(int num : set){
            if(!set.contains(num - 1)){
                int curr = num;
                int currLen = 1;

                while(set.contains(curr + 1)){
                    curr++;
                    currLen++;
                }
                maxLen = Math.max(maxLen,currLen);
            }
        }
        return maxLen;
    }
}
