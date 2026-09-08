class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // combo sum. + subsets 2
        // T: O(n * 2^n)
        // S: O(n)
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        // must sort for dupes tp be next to another and dupe checker to work
        Arrays.sort(candidates);
        bt(candidates, target, 0, path, result);
        return result;
    }

    private void bt(
        int[] candidates, 
        int remaining, 
        int start, 
        List<Integer> path, 
        List<List<Integer>> result){

            // save path if remainder = 0 aka with found a valid combo
            if(remaining == 0){
                result.add(new ArrayList<>(path));
                return;
            }

            for(int i = start; i < candidates.length; i++){
                // dupe checker
                if(i > start && candidates[i] == candidates[i - 1]) continue;
                // since arr is sorted, if the num too big, everything after is too
                if(candidates[i] > remaining) break;

                // choose
                path.add(candidates[i]);
                // bt
                bt(candidates, remaining - candidates[i], i + 1, path, result);
                // choose/ undo
                path.remove(path.size() - 1);
            }
    }
}
