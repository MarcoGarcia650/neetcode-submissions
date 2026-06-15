class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Input: String[]
        // Output: List<List<String>>

        // For each word:
        //     convert to char[]
        //     sort chars
        //     make sorted chars into String key

        //     if key not in map:
        //         create empty list

        //     add original word to key's list

        // Return all map values.

        if(strs.length == 0) return new ArrayList<>();

        HashMap<String, List<String>> map = new HashMap<>();

        for(String word : strs){
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String key = new String (chars);
        
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(word);
        }

        return new ArrayList<>(map.values());

        // Each word gets sorted.
        // Sorting one word costs k log k.
        // There are n words.
        // So time = O (n * k log k)

        // We store all words in the map.
        // Total characters stored ≈ n * k.
        // So space = O(n * k).

    }
}
