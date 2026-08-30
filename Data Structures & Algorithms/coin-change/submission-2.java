class Solution {
    public int coinChange(int[] coins, int amount) {
        // T: O(amount * num of coins)
        // S: O(amount)

        int[] dp = new int[amount + 1];

        // ex. amount = 12: its impossible to use 13 [whole] coins to make 12
        Arrays.fill(dp, amount + 1);

        dp[0] = 0; // 0 coins to make amount 0

        for(int i = 1; i <= amount; i++){
            for(int coin : coins){

                // if coin can fit into current amount, num of ways equals smallest of
                if(coin <= i){
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }
        // if amount = amount + 1 from fill, amount is unreachable
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
