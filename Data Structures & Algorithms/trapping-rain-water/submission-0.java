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
            if(height[left] < height[right]){
                if(height[left] >= leftMax){
                    leftMax = height[left];
                } else{
                    water += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax){
                    rightMax = height[right];
                } else {
                    water += rightMax - height[right];
                }
                right--;
            }
        }
        return water;

    }
}
