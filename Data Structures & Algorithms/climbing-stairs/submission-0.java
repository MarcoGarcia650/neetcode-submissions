class Solution {
    public int climbStairs(int n) {
        // base cases
        // n = 2;
        // n = 1;
        // (n + 2) + (n + 1)
        if(n == 1) return 1;
        if(n == 2) return 2;

        //dp[i] = number of ways to reach step i
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        // build up from bottom
        for (int i = 3; i <= n; i++){
            // ways to reach i = from i-1 + from i -2
            dp[i] = dp[i -1] + dp[ i -2];
        }

        return dp[n];
    }
}
