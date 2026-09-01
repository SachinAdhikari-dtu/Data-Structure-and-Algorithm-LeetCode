class Solution {
    public static int help(int arr[], int i, int n, int curr, int dp[][][]) {
        // Base cases
        if (n == 0 || i == arr.length) return 0;
        if (dp[i][n][curr] != -1) return dp[i][n][curr];
        
        if (curr == 1) { // Holding stock
            // Sell (complete transaction) OR hold
            int sell = arr[i] + help(arr, i+1, n-1, 0, dp); // ✅ Decrement on sell
            int hold = help(arr, i+1, n, 1, dp);
            dp[i][n][curr] = Math.max(sell, hold);
            return dp[i][n][curr];
        } else { // Not holding stock (curr == 0)
            // Buy OR skip
            int buy = -arr[i] + help(arr, i+1, n, 1, dp); // ✅ Don't decrement on buy
            int skip = help(arr, i+1, n, 0, dp);
            dp[i][n][curr] = Math.max(buy, skip);
            return dp[i][n][curr];
        }
    }
    
    public int maxProfit(int[] prices) {
        int dp[][][] = new int[prices.length][3][2];
        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j < 3; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        // Start with curr=0 (not holding), transactions=2
        return help(prices, 0, 2, 0, dp);
    }
}