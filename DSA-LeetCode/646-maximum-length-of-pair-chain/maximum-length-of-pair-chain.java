class Solution {
    public static int help(int arr[][] , int i , int p , int dp[][]){
        if(i==arr.length)return 0;
        if(p!=-1 && dp[i][p]!=-1)return dp[i][p];
         int skip=help(arr,i+1,p,dp);
            int take=0;
         if(p==-1 || check(arr,i,p)){
            take=1+help(arr,i+1,i,dp);
         }
         if(p!=-1)dp[i][p]=Math.max(take,skip);
         return Math.max(skip,take);
    }
    public static boolean check(int arr[][]  , int i , int p ){
        return arr[p][1]<arr[i][0];
    }
    public int findLongestChain(int[][] pairs) {
        int n= pairs.length;

        int dp[][]=new int[n+1][n+1];
        for(int i =0 ; i <= n ; i++){
            for(int j= 0 ; j <= n  ; j++){
                dp[i][j]=-1;
            }
        }
        Arrays.sort(pairs,(a,b)->Integer.compare(a[0],b[0]));
        return help(pairs,0,-1,dp);
    }
}