class Solution {

// Encode
    // Write the word's length.
    // Write #.
    // Write the word.    

// Decode
    // Move j until #.
    // Everything from i to j is the length.
    // Convert "5" to integer 5.
    // After #, read exactly 5 characters.
    // Add that word.
    // Move i to the next encoded word.

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        // loop throguh string list
        for(String s : strs){

            // add str length to string builder
            sb.append(s.length());
            // add #
            sb.append('#');
            // add str
            sb.append(s);
        }
        // return encoded str
        return sb.toString();
    }

    public List<String> decode(String str) {
        // result list
        List<String> result = new ArrayList<>();

        int i = 0;
        
        // while within length of encoded string
        while(i < str.length()){
            int j = i;

            // while not at #, walk j
            while(str.charAt(j) != '#'){
                j++;
            }

            // length is equal to parsed int from substring; ie i, j = "4" -> parsed = 4
            int len = Integer.parseInt(str.substring(i, j));

            // word is made from substring found
            // ie word  = subtring (2, 6) = "leet"
            String word = str.substring(j + 1, j + 1 + len);

            // add it to the result list
            result.add(word);

            // move i to end of found string, where next num length of next word is
            // ie i == 4, leet -> i == 4, code
            i = j + 1 + len;
        }
        return result;
    }
}
