class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // T: O(n * 2^n), up to 2^n subsets, copying each is n; sorting has nlogn but dominated
        // S: O(n)
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        // need to sort so any dupes next to each other
        Arrays.sort(nums);
        bt(nums, 0, path, res);
        return res;
    }

    private void bt(int[] nums, int start, List<Integer> path, List<List<Integer>> res){
        // save path
        res.add(new ArrayList<>(path));

        for(int i = start; i < nums.length; i++){

            if(i > start && nums[i] == nums[i - 1]) continue;

            // Case 1: Choose
            path.add(nums[i]);

            bt(nums, i + 1, path, res);

            // Case 2: Not Choose/ Undo
            path.remove(path.size() - 1);
        }
    }
}
