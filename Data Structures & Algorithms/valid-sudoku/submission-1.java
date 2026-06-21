class Solution {
    public boolean isValidSudoku(char[][] board) {
        // optimal solution:
        // use nested for loop and 1 hashset of Strings
        // hashset check whether current key has been seen before
        // if not, add it, and continue in nested for loop
        // Time: O(n^2)
        // Space: O(1)

        // edge case:
        if(board.length == 0 || board[0].length == 0) return false;

        HashSet<String> seen = new HashSet<>();

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char val = board[r][c];

                if (val == '.') continue;

                String rowKey = val + " in row " + r;
                String colKey = val + " in col " + c;
                String boxKey = val + " in box " + (r / 3) + "-" + (c / 3);

                if (
                    seen.contains(rowKey) ||
                    seen.contains(colKey) ||
                    seen.contains(boxKey)
                ) {
                    return false;
                }

                seen.add(rowKey);
                seen.add(colKey);
                seen.add(boxKey);
            }
        }
        return true;
    }
}
