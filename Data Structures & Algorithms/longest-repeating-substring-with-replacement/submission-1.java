class Solution {
    public int characterReplacement(String s, int k) {
        // sliding window, hashmap
        // window logic: when num of changes needed exceeds allowed
        // strat:
        // track/ update most freq char; if window size minues this char is more than k, shrink window
        // and deduct 1 from left char from map; update maxLen

        HashMap<Character, Integer> map = new HashMap<>();

        int left = 0;
        int maxLen = 0;
        int freq = 0;

        for(int right = 0; right < s.length(); right++){
            char curr = s.charAt(right);
            map.put(curr, map.getOrDefault(curr, 0 ) + 1);
            freq = Math.max(freq, map.get(curr));

            while((right - left + 1) - freq > k){
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar)- 1);
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
