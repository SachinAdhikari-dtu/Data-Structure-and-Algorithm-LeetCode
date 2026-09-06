class Solution {
    public int lengthOfLIS(int[] nums) {
        int n= nums.length;
        int dp[][]=new int[n+1][n+1];
        for(int i = 0 ; i <= n ;i++){
            for(int j = 0 ; j <= n ; j++){
                dp[i][j]=-1;
            }
        }

        return lis(nums,0,-1,dp);
    }
    public static int lis(int arr[] , int i , int  p , int dp[][]){
        if(i==arr.length)return 0;
        if(p!=-1 && dp[i][p]!= -1)return dp[i][p];
        int skip=lis(arr,i+1,p,dp);
        int take=0;
        if(p==-1 || arr[p]<arr[i]){
            take=1+lis(arr,i+1,i,dp);
        }
        if(p!=-1)dp[i][p]=Math.max(skip,take);
        return Math.max(take,skip);
    }
}