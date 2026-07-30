class Solution {
    public boolean exist(char[][] board, String word) {
        // dfs, recursion

        // get len of rows and columns
        int rows = board.length;
        int cols = board[0].length;

        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                // run dfs at each char
                if(dfs(board, word, r, c, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int r, int c, int i){
        // if we found all word chars in valid path, true
        if(i == word.length()) return true;

        // out of bounds check
        if(r < 0 || c < 0 || r >= board.length || c >= board[0].length) return false;

        // if char at this part of board not match, false
        if(board[r][c] != word.charAt(i)) return false;

        // save curr char
        char temp = board[r][c];

        // temp mark it 'seen'
        board[r][c] = '#';

        // run dfs in all 4 directions at this point
        // only way to make it here is if char matches, so we check around it but mark it so it may not be double used in path 
        // invalidly
        boolean found =     dfs(board, word, r + 1, c, i + 1) ||
                            dfs(board, word, r - 1, c, i + 1) || 
                            dfs(board, word, r, c + 1, i + 1) ||
                            dfs(board, word, r, c - 1, i + 1);

        // return char back to og value
        board[r][c] = temp;

        // return whether we found next char in valid path
        return found;
    }
}