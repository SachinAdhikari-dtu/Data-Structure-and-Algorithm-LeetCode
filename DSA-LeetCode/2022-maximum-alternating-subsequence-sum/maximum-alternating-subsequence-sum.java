class Solution {
    public long help(int i , long dp[][] , int arr[] , int flag){
        if(i >= arr.length)return 0;
        if(dp[i][flag] != -1)return dp[i][flag];
        long val=arr[i];
    if(flag==1){
        val*=-1;
    }
        
    
        long a=help(i+1,dp,arr,1-flag)+val;
        dp[i][flag]=(long)Math.max(help(i+1,dp,arr,flag),a);
        return dp[i][flag];
    }
    public long maxAlternatingSum(int[] nums) {
        long dp[][]=new long[nums.length+1][2];

        for(int i =0 ; i < dp.length ; i++){
            Arrays.fill(dp[i],-1);
        }

        return help(0,dp,nums,0);
    }
}