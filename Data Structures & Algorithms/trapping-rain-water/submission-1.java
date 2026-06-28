class Solution {
    public int trap(int[] height) {
        // 2 ptr
        // have a leftMax and right max
        // move smallest ptr
        // before moving it, see if left ptr is greater than leftMax, if so update it, else, add to water,
        // same for right
        // return water

        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int water = 0;

        while(left < right){
            // if left post is smaller than right
            if(height[left] < height[right]){
                // if curr post is taller than prev tallest left post, update is
                if(height[left] >= leftMax){
                    leftMax = height[left];
                } else{
                    // else just add the water which is left post max - curr height
                    water += leftMax - height[left];
                }
                // move left ptr to check for more water
                left++;
            } else {
                // else right post is smaller; if curr right post > prev tallest right post, update it
                if (height[right] >= rightMax){
                    rightMax = height[right];
                } else {
                    // else add water
                    water += rightMax - height[right];
                }
                // and mvoe right ptr to check for move water
                right--;
            }
        }
        return water;

    }
}
