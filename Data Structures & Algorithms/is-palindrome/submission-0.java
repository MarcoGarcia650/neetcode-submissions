class Solution {
    public boolean isPalindrome(String s) {
        // 2 ptr
        // break into chars
        // if left ptr == right ptr, move both, if else, false
        // while left <= right ptr

        int left = 0;
        int right = s.length() - 1;

        while(left < right){

            while(left < right && !Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }

            while(left < right && !Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }

            // chars are now valid, check

            if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) return false;
            left++;
            right--;
        }
        return true;
        
    }
}
