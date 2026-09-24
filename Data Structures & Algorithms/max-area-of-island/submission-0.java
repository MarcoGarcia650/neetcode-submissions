class Solution {        
    private int maxArea = 0;

    public int maxAreaOfIsland(int[][] grid) {
        // dfs
        // similar to number of islands
        // main: controls starting point/ cell, take dfs area and max area
        // dfs: when land found, count more land and return int of area of curr islands
        // T: O(m x n)
        // S: O(m x n)


        for(int r = 0; r < grid.length; r++){
            for(int c = 0; c < grid[0].length; c++){
                if(grid[r][c] == 1){
                    int currArea = dfs(grid, r, c);
                    maxArea = Math.max(maxArea, currArea);
                }
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, int r, int c){
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == 0){
            return 0;
        }

        grid[r][c] = 0;
        int maxArea = 1;

        maxArea += dfs(grid, r + 1, c);
        maxArea += dfs(grid, r - 1, c);
        maxArea += dfs(grid, r, c + 1);
        maxArea += dfs(grid, r, c - 1);

        return maxArea;
    }
}
