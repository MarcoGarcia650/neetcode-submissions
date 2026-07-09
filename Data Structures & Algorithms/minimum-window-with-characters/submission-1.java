class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length()) return "";

        // need map contains t chars which will be reference for window, which contains window s chars
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        for(char c : t.toCharArray()){
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        // counts how many valid t chars in s window
        int have = 0;
        // length of t; window must have this size to potentially be valid
        int needed = need.size();
        int minLen = Integer.MAX_VALUE;
        // tracks start of shortest found valid winLen so far
        int minStart = 0;

        for(int right = 0; right < s.length(); right++){
            char rightChar = s.charAt(right);

            // add s chars to map window
            window.put(rightChar, window.getOrDefault(rightChar, 0 ) + 1);

            // if s window right char is needed, increment have
            if  (need.containsKey(rightChar) && 
                window.get(rightChar).intValue() == need.get(rightChar).intValue()
                )
                {
                have++;
            }

            // while window has all needed t chars
            while(have == needed){
                // get current window length
                int windowLen = right - left + 1;

                // if curr valid window len shorter than prev min substring, update minLen, and update
                // valid window len start index
                if(windowLen < minLen){
                    minLen = windowLen;
                    minStart = left;
                }

                // now start shrinking window to see if still valid when shorter
                char leftChar = s.charAt(left);
                window.put(leftChar, window.get(leftChar) - 1);

                // if the left window char being removed is from have/ needed t chars, update have - 1
                if(need.containsKey(leftChar) && window.get(leftChar) < need.get(leftChar)){
                    have--;
                }
                // shrnk window
                left++;
            }
        }

        // if we still havent found valid window, return ""
        if(minLen == Integer.MAX_VALUE){
            return "";
        }
        // return valid substring
        return s.substring(minStart, minStart + minLen);
    }
}
