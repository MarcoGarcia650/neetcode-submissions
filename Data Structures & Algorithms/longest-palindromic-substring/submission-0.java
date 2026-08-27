class Solution {
    public String longestPalindrome(String s) {
        // T: O(n^2)
        // T: O(n)
        // make a string res
        String res = "";

        // starting from each char, expand
        for(int i = 0; i < s.length(); i++){

            // case: odd len str
            String odd = expand(s, i, i);
            // will check every odd substring, if its palindromic, get longest one
            if(odd.length() > res.length()){
                res = odd;
            }

            // case: even len str
            String even = expand(s, i, i + 1);
            // checkcs every even substring, if its palondromic and longer than previous, update res
            if(even.length() > res.length()){
                res = even;
            }
        }
        return res;
    }

    private String expand(String s, int left, int right){

        // while within bounds and chars match, expand
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }

        // return substring 
        return s.substring(left + 1, right);
    }
}
