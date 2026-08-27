class Solution {

    private int count;

    public int countSubstrings(String s) {
        // use helper function to search for palindromes usin expansion method
        // count both even and odd palindromes
        // T: O(n^2)
        // S: O(1)
        count = 0;

        for(int i = 0; i < s.length(); i++){
            
            count += expand(s, i, i);       // count + all odd palidromes
            count += expand(s, i, i + 1);   // count + all even palindromes
        }
        return count;
    }

    private int expand(String s, int left, int right){

        count = 0;

        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            // only count when chars match aka its a palindrome
            count++;
            // expanding to check for more
            left--;
            right++;
        }
        // return count
        return count;
    }
}
