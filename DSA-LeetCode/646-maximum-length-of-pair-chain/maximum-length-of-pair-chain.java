class Solution {
    public static int help(int arr[][], int i, int p, int dp[][]) {
        // Base case: reached end of array
        if (i == arr.length) return 0;
        
        // Map p (-1) to a valid index (0)
        int pIndex = p + 1;
        
        // Check if already computed
        if (dp[i][pIndex] != -1) return dp[i][pIndex];
        
        // Option 1: Skip current pair
        int skip = help(arr, i + 1, p, dp);
        
        // Option 2: Take current pair (if it can chain)
        int take = 0;
        if (p == -1 || arr[p][1] < arr[i][0]) {
            take = 1 + help(arr, i + 1, i, dp);
        }
        
        // Store the result (for ALL cases)
        dp[i][pIndex] = Math.max(skip, take);
        
        return dp[i][pIndex];
    }
    
    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        
        // Sort by first element
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0]));
        
        // DP table: dp[i][pIndex] where pIndex = p + 1
        int dp[][] = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }
        
        return help(pairs, 0, -1, dp);
    }
}