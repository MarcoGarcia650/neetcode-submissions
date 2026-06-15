class Solution {
    public int lengthOfLongestSubstring(String s) {
        // sliding window
        // window valid: when currChar not seen in hashmap before

        HashSet<Character> set = new HashSet<>();

        int left = 0;
        int maxLen = 0;

        for(int right = 0; right < s.length(); right++){
            char curr = s.charAt(right);

            while(set.contains(curr)){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(curr);
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
        
    }
}
