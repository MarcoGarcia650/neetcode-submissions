class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        // T: O(m * n)
        // S: O(m * n) for visited arrays + DFS recursion stack
        // do dfs from ocean, 2 loops--parallel sides; get atl and pac 2d bool arr
        // for each bool arr, mark true in cell if water dfs from ocean can reach it
        // then, do check both bool arrs; if both oceans touch a cell, add to res
        // dfs: 1 visited 2d bool arr; alr visited check; OOB check; mark; for each dir,
        // if next cell larger than curr cell, do dfs there

        int row = heights.length;
        int col = heights[0].length;

        boolean[][] pacific = new boolean[row][col];
        boolean[][] atlantic = new boolean[row][col];

        // dfs from top (P) and bottom (A)
        for(int c = 0; c < col; c++){
            dfs(heights, 0, c, pacific);
            dfs(heights, row - 1, c, atlantic);
        }

        // dfs from left (P) and right (A)
        for(int r = 0; r < row; r++){
            dfs(heights, r, 0, pacific);
            dfs(heights, r, col - 1, atlantic);
        }

        List<List<Integer>> result = new ArrayList<>();

        // if both oceans can reach this cell, add coordinates to res
        for(int r = 0; r < row; r++){
            for(int c = 0; c < col; c++){
                if(pacific[r][c] && atlantic[r][c]){
                    result.add(Arrays.asList(r,c));
                }
            }
        }
        return result;
    }

    private void dfs(int[][] heights, int r, int c, boolean[][] visited){
        if(visited[r][c]) return; // already visited
        int row = heights.length;
        int col = heights[0].length;

        visited[r][c] = true; // mark visited

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for(int[] dir : dirs){
            int nr = r + dir[0];
            int nc = c + dir[1];

            // out of bounds check
            if(nr < 0 || nc < 0 || nr >= row || nc >= col) continue;

            if(heights[nr][nc] >= heights[r][c]){
                dfs(heights, nr, nc, visited);
            }
        }
    }
}
