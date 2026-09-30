class Solution {
    public static int lis(int nums[] , int i , int p , int dp[][]){
        if(i >= nums.length )return 0;
        if(p!=-1 && dp[i][p]!=-1)return dp[i][p];
        //not take
        int l= lis(nums,i+1,p,dp);

        int r=0;
        if(p==-1 ||  nums[p] < nums[i]){
            r=1+lis(nums,i+1,i,dp);
        }
        if(p!=-1)dp[i][p]=Math.max(l,r);
        return Math.max(l,r);
    }
    public int lengthOfLIS(int[] nums) {
        int dp[][]=new int[nums.length+1][nums.length+1];
        for(int i= 0 ; i <= nums.length ; i++){
            Arrays.fill(dp[i],-1);
        }
        return lis(nums,0,-1,dp);
    }
}