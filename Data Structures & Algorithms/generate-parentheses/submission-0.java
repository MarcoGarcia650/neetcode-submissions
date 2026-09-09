class Solution {
    public List<String> generateParenthesis(int n) {
        // T: O(4^ / sqrtn) approx using cataln number
        // S: O(n)
        List<String> results = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        bt(n, 0, 0, path, results);
        return results;
    }

    private void bt(int n, int open, int close, StringBuilder path, List<String> results){
        if(open == n && close == n){
            results.add(path.toString());
        }

        // still more pairs possible, bt
        if(open < n){
            // choose
            path.append('(');
            // bt
            bt(n, open + 1, close, path, results);
            // not choose/ undo
            path.deleteCharAt(path.length() - 1);
        }

        // not all started pairs have closed, bt
        if(close < open){
            // choose
            path.append(')');
            // bt
            bt(n, open, close + 1, path, results);
            // not choose/ undo
            path.deleteCharAt(path.length() - 1);
        }
    }
}
