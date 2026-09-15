class Solution {
    public List<List<String>> solveNQueens(int n) {
        // T: O(n!) n rows and up to n coloum choices; daigonal pruning makes it faster but this is standard bound
        // S: O(n^2) because recursion stack goes at most n deep and the sets are O(n), and board is n^2

        List<List<String>> result = new ArrayList<>();

        HashSet<Integer> cols = new HashSet<>(); // col is jsut col
        HashSet<Integer> posDiag = new HashSet<>(); // row + col is always constant for pos diag moves
        HashSet<Integer> negDiag = new HashSet<>();// row - col is always constant for neg diag moves

        char[][] board = new char[n][n];

        // prefill board as empty
        for(int row = 0; row < n; row++){
            Arrays.fill(board[row], '.');
        }

        bt(0, n, board, cols, posDiag, negDiag, result);

        return result;
    }

    private void bt(
        int row, 
        int n, 
        char[][] board,
        HashSet<Integer> cols, 
        HashSet<Integer> posDiag, 
        HashSet<Integer> negDiag, 
        List<List<String>> result){

        // placed one queen in every row
        if(row == n){
            List<String> solution = new ArrayList<>();

            for(char[] boardRow : board){
                solution.add(new String(boardRow));
            }

            result.add(solution);
            return;
        }

        // try putting this row's queen in every column
        for(int col = 0; col < n; col++){
            
            // if spot crosses prev row's queen's path, skip
            if(
                cols.contains(col) ||
                posDiag.contains(row + col) ||
                negDiag.contains(row - col) ||
                board[row][col] == 'Q'){
                    continue;
            }

            // Case 1: choose this spot for this row's queen
            cols.add(col);
            posDiag.add(row + col);
            negDiag.add(row - col);
            board[row][col] = 'Q';

            // bt: this row now has a queen; move to next row
            bt(row + 1, n, board, cols, posDiag, negDiag, result);

            // Case 2: not choose/ undo
            cols.remove(col);
            posDiag.remove(row + col);
            negDiag.remove(row - col);
            board[row][col] = '.';
        }
    }
}
