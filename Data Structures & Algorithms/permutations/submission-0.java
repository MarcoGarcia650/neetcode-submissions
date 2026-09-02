class Solution {
    public List<List<Integer>> permute(int[] nums) {
        // bt
        // T: O(n * n!); n! complete computations, copying each is O(n)
        // ie num len = 3, (1 * 2 * 3) times you copy len 3 perms 
        // S: O(n)

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        boolean[] used = new boolean[nums.length];

        bt(nums, used, path, result);
        return result;
    }

    private void bt(int[] nums, boolean[] used, List<Integer> path, List<List<Integer>> result){

        if(path.size() == nums.length){
            result.add(new ArrayList<>(path));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(used[i]) continue;

            // Case 1: choose
            path.add(nums[i]);
            used[i] = true;

            // bt
            bt(nums, used, path, result);

            // Case 2: not choose/ undo
            path.remove(path.size() - 1);
            used[i] = false;
        } 
    }
}
