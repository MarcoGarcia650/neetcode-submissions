class Solution {
    public void solve(char[][] board) {
        // dfs
        // T: O(m x n)
        // S: O(m x n)
        int rows = board.length;
        int cols = board[0].length;

        // check boundaries for O's; dfs inward, mark as T, protected
        for(int r = 0; r < board.length; r++){
            if(board[r][0] == 'O'){
                dfs(board, r, 0);
            }

            if(board[r][cols - 1] == 'O'){
                dfs(board, r, cols - 1);
            }
        }

        for(int c = 0; c < board[0].length; c++){
            if(board[0][c] == 'O'){
                dfs(board, 0, c);
            }

            if(board[rows - 1][c] == 'O'){
                dfs(board, rows - 1, c);
            }
        }

        // restore board
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                // found unprotect O, convert to X
                if(board[r][c] == 'O'){
                    board[r][c] = 'X';
                } else if (board[r][c] == 'T'){
                    // found protected O, convert back to O
                    board[r][c] = 'O';
                }
            }
        }

    }

    private void dfs(char[][] board, int r, int c){
        // if out of bounds or char is X, return
        if(r < 0 || c < 0 || r >= board.length || c >= board[0].length || board[r][c] != 'O'){
            return;
        }

        board[r][c] = 'T';
        dfs(board, r + 1, c);
        dfs(board, r - 1, c);
        dfs(board, r, c + 1);
        dfs(board, r, c - 1);
    }
}
