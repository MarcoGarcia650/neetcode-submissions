class Solution {
    public int maxArea(int[] heights) {
        // 2 ptr
        // width, height, area
        // height is smaller of the two ptrs
        // capture biggest seen container and update throughout while loop

        int left = 0;
        int right = heights.length - 1;
        int maxArea = 0;

        while(left < right){
            int height = Math.min(heights[left], heights[right]);
            int width = right - left;
            int area = height * width;

            maxArea = Math.max(maxArea, area);

            if(heights[left] < heights[right]){
                left++;
            } else {
                right--;
            }

        }
        return maxArea;
        
    }
}
