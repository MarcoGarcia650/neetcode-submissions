class Solution {
    public int largestRectangleArea(int[] heights) {
        // stack will hold start index and bar height
        // ie [2,5] means height 5 can start as far left as index 2

        Stack<int[]> stack = new Stack<>();
        int maxArea = 0;

        for(int i = 0; i < heights.length; i++){
            // by default, this bar starts at its own index
            int start = i;

            // if current bar is shorter than bar on top, taller bar can't continue any further
            while(!stack.isEmpty() && stack.peek()[1] > heights[i]){
                // give me top saved rectangle, tell me where it started, and how tall it was
                int[] bar = stack.pop();
                int index = bar[0];
                int height = bar[1];
                // calc the rectangle's area
                int width = i - index;
                int area = height * width;

                maxArea = Math.max(maxArea, area);

                // curr shorter bar can extend left to where taller popped bar started
                start = index;
            }
            // save curr bar with earliest pos it's able to start from 
            stack.push(new int[] {start, heights[i]});
        }

        // any bars still in stack never found short bar, so they extend all the way to the end
        while(!stack.isEmpty()){
            int[] bar = stack.pop();
            int index = bar[0];
            int height = bar[1];
            int width = heights.length - index;
            int area = height * width;

            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}
