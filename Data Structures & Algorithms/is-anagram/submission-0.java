class Solution {
    public boolean isAnagram(String s, String t) {
        // lengths much match else automatic fail
        if(s.length() != t.length()) return false;

        // char, count
        HashMap<Character, Integer> map = new HashMap<>();

        // count chars in s
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            // increase count or start at zero if not already seen
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for(int i = 0; i < t.length(); i++){
            char c = t.charAt(i);

            //if char doesnt exist or already used up
            if(map.getOrDefault(c,0) == 0) return false;

            //use one occurence
            map.put(c, map.get(c) - 1);
        }

        // test passed
        return true;
    }
}
