class Solution {
    public static int help(int arr[] , int i , int ans , int min){
        if(i==arr.length )return ans;
        ans=Math.max(ans,arr[i]-min);
        min=Math.min(min,arr[i]);
        return help(arr,i+1,ans,min);
    }
    public int maxProfit(int[] arr) {
       return help(arr,1,0,arr[0]);
    }
}