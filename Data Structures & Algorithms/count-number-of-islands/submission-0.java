class Solution {
    public int numIslands(char[][] grid) {
        // graph; bfs or dfs work, dfs a little easier to remember
        // logic: if you see an island, increment island counter and 'sink' it by putting 0
        // T: O(m * n)
        // S: O(m * n)

        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;

        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(grid[r][c] == '1'){
                    count++;
                    dfs(grid, r, c);
                }
            }
        } 
        return count;
    }

    private void dfs(char[][] grid, int r, int c){
        // base case: out of bounds OR water
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == '0'){
            return;
        }

        // mark curr cell as visited (sunk)
        grid[r][c] = '0';

        // explore all 4 directions around cell
        dfs(grid, r + 1, c); // down
        dfs(grid, r - 1, c); // up
        dfs(grid, r, c + 1); // right
        dfs(grid, r, c - 1); // left
    }
}
