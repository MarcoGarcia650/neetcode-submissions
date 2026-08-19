class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        // subsets but only add to results if and only if subset sum == target

        // T: O(n * 2^n)
        // S: O(n)

        List<List<Integer>> results = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        bt(nums, target, 0, results, path);

        return results;
    }

    private void bt(
        int[] nums, 
        int remaining, 
        int start, 
        List<List<Integer>> results, 
        List<Integer> path){
        
        // save a copy if sum == target
        if(remaining == 0){
            results.add(new ArrayList<>(path));
            return;
        }

        if(remaining < 0) return;

        // loop through nums
        for(int i = start; i < nums.length; i++){
            // case: choose
            path.add(nums[i]);
            // bt
            bt(nums, remaining - nums[i], i, results, path);
            // case: not choose
            path.remove(path.size() - 1);
        }
    }
}
