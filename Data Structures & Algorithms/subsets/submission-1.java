class Solution {
    public List<List<Integer>> subsets(int[] nums) {

        // needs results list of lists of subsets
        // need path lists told each subset
        // need to make backtracking function; nums, results list, path list, start tracker

        List<List<Integer>> results = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        
        backtrack(nums, results, path, 0);

        return results;
    }

    private void backtrack(int[] nums, List<List<Integer>> results, List<Integer> path, int start){
        // save copy of path
        results.add(new ArrayList<>(path));

        // loop through nums
        for(int i = start; i < nums.length; i++){
            // choose
            path.add(nums[i]);
            // backtrack
            backtrack(nums, results, path, i + 1);
            // not choose
            path.remove(path.size() - 1);
        }
    }
}
