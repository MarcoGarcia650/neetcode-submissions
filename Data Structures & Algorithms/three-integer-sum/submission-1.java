class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        // 2 ptrs and array list of list of integers
        // 2 sum style logic
        // strat:
        // sort nums
        // do for loop and anchor i
        // do 2 ptr search to find valid sums
        // skip dupes
        // return result arr

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 2; i++){
            int left = i + 1;
            int right = nums.length - 1;

            // skip zeros and dupes as they nothing and violate rule
            if(i > 0 && nums[i] == nums[i - 1]) continue;

            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];

                if(sum == 0){
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // move smaller ptr and skip dupes while valid
                    while(left < right && nums[left] == nums[left + 1]) left++;
                    while(left < right && nums[right] == nums[right - 1]) right--;
                    // move both ptrs to search for another valid answer
                    left++;
                    right--;
                } else if (sum < 0){
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
        
    }
}
