class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {   
        // T: O(log(m * n)) binary search on 2D arr
        // S: O(1)
        // treat this as a sorted 1D array

        int rows = matrix.length;
        int cols = matrix[0].length;

        int left = 0;
        // left is start of 2D; right is last val
        int right = rows * cols - 1;

        while(left <= right){
            int mid = left + (right - left) / 2;
            // converting fake 1D arr back to 2D arr to get curr vlaue
            // ie mid = 6, cols = 4; 6/4 = 1; 6%4 = 2
            // val = matrix[1][2] = 12 in ex. 1
            int row = mid / cols;
            int col = mid % cols;
            int value = matrix[row][col];

            // then regular binary search
            if(value == target){
                return true;
            } else if (value < target){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
        
    }
}
