class Solution {
    public List<String> letterCombinations(String digits) {
        // T: O(n * 4^n) 4 because longest digit str is 4
        // S: O(n)
        List<String> results = new ArrayList<>();

        if(digits.length() == 0) return results;

        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        StringBuilder path = new StringBuilder();
        bt(digits, 0, map, path, results);
        return results;
    }

    private void bt(
        String digits, 
        int index, 
        HashMap<Character, String> map, 
        StringBuilder path, 
        List<String> results){
        
        if(index == digits.length()){
            results.add(path.toString());
            return;
        }
        char digit = digits.charAt(index);
        String letters = map.get(digit);

        for(int i = 0; i < letters.length(); i++){
            // choose
            path.append(letters.charAt(i));
            //bt
            bt(digits, index + 1, map, path, results);
            // node choose/ undo
            path.deleteCharAt(path.length() - 1);
        }
    }
}
