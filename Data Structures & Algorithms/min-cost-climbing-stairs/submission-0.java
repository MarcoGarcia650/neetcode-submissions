class Solution {
    public int minCostClimbingStairs(int[] cost) {
        // calculating each element's cheapest path to top
        // start at third-to-last stair b/c final two can jump directly to top
        for(int i = cost.length - 3; i >= 0; i--){
            // pay current cost at i then take the cheapest next step
            cost[i] += Math.min(cost[i + 1], cost[i + 2]);
        }

        // only care about the first 2 steps; return the cheapest
        return Math.min(cost[0], cost[1]);
        // T: O(n)
        // S: O(1) modifies og arr
    }
}
