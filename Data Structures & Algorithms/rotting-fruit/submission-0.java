class Solution {
    public int orangesRotting(int[][] grid) {
        // bfs
        // T: O(m * n)
        // S: O(m * n) queue

        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;

        // Step 1: initialize
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(grid[r][c] == 2){
                    queue.offer(new int[] {r,c}); // rotten
                } else if (grid[r][c] == 1){
                    fresh++;                      // fresh count
                }
            }
        }

        int minutes = 0;

        // Step 2: BFS
        while(!queue.isEmpty() && fresh > 0){
            int size = queue.size();                // current layer

            for(int i = 0; i < size; i++){
                int[] curr = queue.poll();
                int r = curr[0];
                int c = curr[1];
                int[][] directions = {
                    {1, 0}, // down
                    {-1, 0}, // up
                    {0, 1}, // right
                    {0, -1} // left
                };
                
                for(int[] dir : directions){
                    int nr = r + dir[0];
                    int nc = c + dir[1];
                    // skip put of bounds OR anything that isn't fresh
                    if(nr < 0 || nc < 0 || nr >= rows || nc >= cols || grid[nr][nc] != 1){
                        continue;
                    }
                    // rot this orange
                    grid[nr][nc] = 2;
                    fresh--;

                    // it can rot more oranges next minute
                    queue.offer(new int[]{nr, nc});
                }
            }
            minutes++;
        }
        // if fresh oragnes remain, some were unreachable
        return fresh == 0 ? minutes : -1;
    }
}
