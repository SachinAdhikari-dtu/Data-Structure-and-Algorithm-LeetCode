class Solution {
    int help(int arr[] ,  int index , int dp[]){
        if(index >= arr.length)return 0;
        if(dp[index]!=-1)return dp[index];
        int l=help(arr,index+1,dp);
        int r=help(arr,index+2,dp);
        dp[index]=Math.min(l,r)+arr[index];
        return dp[index];

    }
    public int minCostClimbingStairs(int[] cost) {
        int dp[]=new int[cost.length+1];
        Arrays.fill(dp,-1);
        return Math.min(help(cost,0,dp),help(cost,1,dp));
    }
}