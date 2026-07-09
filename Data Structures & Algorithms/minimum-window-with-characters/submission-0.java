class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length()) return "";

        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        for(char c : t.toCharArray()){
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int have = 0;
        int needed = need.size();
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;

        for(int right = 0; right < s.length(); right++){
            char rightChar = s.charAt(right);

            window.put(rightChar, window.getOrDefault(rightChar, 0 ) + 1);

            if  (need.containsKey(rightChar) && 
                window.get(rightChar).intValue() == need.get(rightChar).intValue()
                )
                {
                have++;
            }

            while(have == needed){
                int windowLen = right - left + 1;

                if(windowLen < minLen){
                    minLen = windowLen;
                    minStart = left;
                }

                char leftChar = s.charAt(left);
                window.put(leftChar, window.get(leftChar) - 1);

                if(need.containsKey(leftChar) && window.get(leftChar) < need.get(leftChar)){
                    have--;
                }
                left++;
            }
        }

        if(minLen == Integer.MAX_VALUE){
            return "";
        }
        return s.substring(minStart, minStart + minLen);
    }
}
