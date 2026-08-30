class Solution {
    public int numDecodings(String s) {
        // T: O(n)
        // S: O(n)
        int n = s.length();

        int[] dp = new int[n + 1];

        dp[n] = 1;

        for(int i = n - 1; i>= 0; i--){

            if(s.charAt(i) == '0'){
                dp[i] = 0;
                continue;
            }

            // use 1 digit
            dp[i] = dp[i + 1];

            // use 2 digits
            // if there are two digits with s len range
            // and if the char at i = 1 OR char at i = 2 AND the next char is <= 6 ;
            // Can i + 1 be 10 <= i <= 26 therefore map to a letter in alpha bet  
            if(i + 1 < n && (s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i + 1) <= '6')){
                dp[i] += dp[i + 2];
            }
        }
        return dp[0];
    }
}
