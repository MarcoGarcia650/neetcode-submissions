class Solution {
    public List<List<String>> partition(String s) {
        // T: O(n * 2^n)
        // n palindrome copies * 2^n possible checks/ paths
        // S: O(n)

        List<List<String>> result = new ArrayList<>();
        List<String> path = new ArrayList<>();

        bt(s, 0, path, result);

        return result;
    }

    private void bt(String s, int start, List<String> path, List<List<String>> result){
        // all chars partitioned
        if(start == s.length()){
            result.add(new ArrayList<>(path));
            return;
        }

        for(int end = start; end < s.length(); end++){

            // us helper function to determine if palindrome; if not, skip/ end path
            if(!isPalindrome(s, start, end)) continue;

            // java substring is [start, endExclusive], so end + 1
            String piece = s.substring(start, end + 1);

            // Case 1: choose
            path.add(piece);

            // bt
            bt(s, end + 1, path, result);

            // Case 2: not choose/ undo
            path.remove(path.size() - 1);
        }
    }

    private boolean isPalindrome(String s, int left, int right){
        // use helper function to do palindrome check
        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
