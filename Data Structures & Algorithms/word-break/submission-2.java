class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // T: O(nmk) (n = s.length) (m = num of dict words)(k = average/ max word len)
        // S: O(n)

        boolean[] dp = new boolean[s.length() + 1];

        dp[s.length()] = true;

        for(int i = s.length() - 1; i >= 0; i--){
            for(String word : wordDict){
                //make sure word fits inside remaining string
                if(i + word.length() <= s.length() && s.startsWith(word, i)){
                    // word matches, so check everything after it works
                    if(dp[i + word.length()]){
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        return dp[0];
    }
}
