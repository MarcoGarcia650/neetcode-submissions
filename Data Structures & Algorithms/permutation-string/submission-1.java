class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // alphabet arrays; s1chars; s2chars window
        // fixed sliding window of max size s1 length
      
        if(s2.length() < s1.length()) return false;

        int[] s1chars = new int[26];
        int[] s2chars = new int[26];

        // get freq count of all s1 chars using ascii conversion
        for(char c : s1.toCharArray()){
            // c - a = 2
            // 99 - 97 = 2
            s1chars[c - 'a']++;
        }

        int left = 0;

        // iterate through s2 chars
        for(int right= 0; right < s2.length(); right++){
            // fill s2 chars freq arr
            s2chars[s2.charAt(right) - 'a']++;

            // if window larget than s1 size, remove left count 1 from s2 chars freq arr and move left ptr
            if(right - left + 1 > s1.length()){
                s2chars[s2.charAt(left) - 'a']--;
                left++;
            }

            // if both arrays are the same at any point during s2char loop, return true
            if(Arrays.equals(s1chars, s2chars)) return true;
        }
        // else false
        return false;
    }
}
