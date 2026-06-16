class Solution {
    public int longestConsecutive(int[] nums) {
        // hashing
        // int hash set
        // strat:
        // fill set with nums
        // for num in set, if num - 1 does not exist in set, start trackers: currLen
        // ^reason: means this is start of new seq; need to track it and comp to maxLen
        // update max CurrLen; return it 

        // edge case:
        if(nums.length == 0) return 0;

        HashSet<Integer> set = new HashSet<>();
        int maxLen = 0;

        for(int num : nums){
            set.add(num);
        }

        for(int num : set){
            
            if(!set.contains(num - 1)){
                int currLen = 1;
                int curr = num;

                while(set.contains(curr + 1)){
                    currLen++;
                    // walker/forward explorer var so num doesnt get updated and loop skips; num = seq start
                    curr++;
                }
                maxLen = Math.max(maxLen, currLen);
            }
        }
        return maxLen;        
    }
}
