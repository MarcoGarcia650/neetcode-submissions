class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // 2 ptr
        // if left ptr + right ptr smaller than target, move left up, else move right down

        int left = 0;
        int right = numbers.length - 1;

        while(left < right){
            if(numbers[left] + numbers[right] == target){
                return new int[] {left + 1, right + 1};
            }
            if(numbers[left] + numbers[right] < target){
                left++;
            } else {
                right--;
            }
        }
        return new int[] {};
        
    }
}
