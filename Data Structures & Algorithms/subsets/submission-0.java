class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        backtrack(nums, 0, path, result);
        return result;   
        // T: O (n * 2^n)
        // S: O(n) extra recursion/ path space, not counting output
    }

    private void backtrack(int[] nums, int start, List<Integer> path, List<List<Integer>> result){
        // save copy
        result.add(new ArrayList<> (path));

        // for each starting at this index, add to path, and try backtracking from next pos; undo
        for(int i = start; i < nums.length; i++){
            path.add(nums[i]);
            backtrack(nums, i + 1, path, result);
            path.remove(path.size() - 1);
        }
    }
}
