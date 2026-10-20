class Solution {
    public void islandsAndTreasure(int[][] grid) {
        // multi source bfs
        // run bfs from 
        // T: O(n * m)
        // S: O(n * m) queue
        Queue<int[]> q = new LinkedList<>();
        int row = grid.length;
        int col = grid[0].length;

        // start with chest locations in queue for bfs
        for(int r = 0; r < row; r++){
            for(int c = 0; c < col; c++){
                if(grid[r][c] == 0){
                    q.offer(new int[] {r,c});
                }
            }
        }

        // down, up, right, left
        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}}; 

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];

            // explore all 4 dirs
            for(int[] dir : directions){
                int nr = r + dir[0];
                int nc = c + dir[1];

                // out of bounds or not traversable
                if(nr < 0 || nc < 0 || nr >= row || nc >= col || grid[nr][nc] != 2147483647){
                    continue;
                }
                grid[nr][nc] = grid[r][c] + 1;
                q.offer(new int[] {nr, nc});
            }
        }
    }
}
