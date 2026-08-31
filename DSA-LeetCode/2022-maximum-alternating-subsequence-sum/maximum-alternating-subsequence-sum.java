class Solution {
    public static long help(int arr[] , long dp[][] , int index , int sign){
        if(index==arr.length)return 0;
        if(dp[index][sign]!=-1)return dp[index][sign];
        long sum=help(arr,dp,index+1,1-sign)+arr[index];
        if(sign==1)sum-=(2*arr[index]);
        sum=Math.max(sum,help(arr,dp,index+1,sign));
        dp[index][sign]=sum;
        return sum;
    }
    public long maxAlternatingSum(int[] nums) {
        long dp[][]=new long[nums.length][2];
        for(int i =0 ; i < nums.length ; i++){
            dp[i][0]=-1;
            dp[i][1]=-1;
        }
         return          help(nums,dp,0,0);

    }
}