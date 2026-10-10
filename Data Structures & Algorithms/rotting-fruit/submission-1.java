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
        // use static offset 
        int[][] directions = {
            {0,1}, // right
            {1,0}, // down
            {0,-1}, // left
            {-1,0} // up
        };

        while(!queue.isEmpty() && fresh > 0){
            int size = queue.size();

            for(int i = 0; i < size; i++){
                int[] curr = queue.poll();
                // get row and col nums from rotten orange we are processing from queue
                int r = curr[0];
                int c = curr[1];

                // calculate where all 4 neighbhors are in grid using offset
                for(int[] dir : directions){
                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    // check if fresh or out of bounds; if fresh, rot it and add to queue
                    if(
                        nr < 0|| nc < 0 || nr >= grid.length || nc >= grid[0].length || 
                        grid[nr][nc] != 1 ){
                        continue;
                    }
                    grid[nr][nc] = 2; // rot it
                    fresh--; // decrement fresh counter
                    queue.offer(new int[] {nr, nc}); // add to queue
                }
            }
            minutes++;
        }
        return fresh == 0 ? minutes : -1;
    }
}

















